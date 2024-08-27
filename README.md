# クローン前の設定 
**Windowsユーザーの場合** 

```bash
git config --global core.autocrlf true
```
 
- `core.autocrlf`を`true`に設定することで、Windows上でファイルをチェックアウトする際に、自動的に改行コードが適切に変換されます。

# 環境構築 

## 1. Java 21 (OpenJDK) のインストール 

### Windows 

WindowsでJava 21 (OpenJDK) をインストールするには、以下の手順をPowerShellで実行します。


```powershell
# OpenJDK 21 を winget を使ってインストール
winget install --id=EclipseAdoptium.Temurin.21.JDK -e

# Java のバージョンを確認
java -version # "java version '21'" と表示されるはずです
```

### macOS 

macOSでJava 21 (OpenJDK) をインストールするには、以下の手順をターミナルで実行します。


```bash
# Homebrew を使って OpenJDK 21 をインストール
brew install openjdk@21

# OpenJDK 21 を使うための環境変数を設定
sudo ln -sfn /usr/local/opt/openjdk@21/libexec/openjdk.jdk /Library/Java/JavaVirtualMachines/openjdk-21.jdk
echo 'export PATH="/usr/local/opt/openjdk@21/bin:$PATH"' >> ~/.bash_profile
source ~/.bash_profile

# Java のバージョンを確認
java -version # "java version '21'" と表示されるはずです
```

## 2. Node.jsのインストール 

### Windows 

WindowsでNode.jsをインストールするには、以下の手順をPowerShellで実行します。


```powershell
# fnm (Fast Node Manager) のインストール
winget install Schniz.fnm

# fnm の環境を設定
fnm env --use-on-cd | Out-String | Invoke-Expression

# Node.js バージョン 20 をダウンロードしてインストール
fnm use --install-if-missing 20

# Node.js のバージョンを確認
node -v # "v20.x.x" と表示されるはずです

# npm のバージョンを確認
npm -v # "10.x.x" と表示されるはずです

# 環境変数に追加 (コマンドプロンプトや他のシェルでも利用可能にする)
$fnmPath = (fnm env --use-on-cd | Out-String).Split(";") | Select-String -Pattern "C:\\.*\.fnm\\node-versions\\v20.*\\bin"

[System.Environment]::SetEnvironmentVariable("PATH", "$env:PATH;$fnmPath", [System.EnvironmentVariableTarget]::User)
```

### macOS 

macOSでNode.jsをインストールするには、以下の手順をターミナルで実行します。


```bash
# fnm (Fast Node Manager) のインストール
curl -fsSL https://fnm.vercel.app/install | bash

# fnm をアクティベート
source ~/.bashrc

# Node.js バージョン 20 をダウンロードしてインストール
fnm use --install-if-missing 20

# Node.js のバージョンを確認
node -v # "v20.x.x" と表示されるはずです

# npm のバージョンを確認
npm -v # "10.x.x" と表示されるはずです
```

## 3. PrettierとPrettier SQL Pluginのインストール 

プロジェクト内のSQLファイルを一括でフォーマットするために、PrettierとPrettier SQL Pluginをインストールします。

### インストール手順 

以下のコマンドをプロジェクトフォルダのルートディレクトリで実行して、PrettierとPrettier SQL Pluginをインストールします。


```bash
npm install --save-dev prettier prettier-plugin-sql
```

# 起動方法 

## 1. Docker Composeでコンテナを起動 

以下のコマンドを実行して、Docker Composeを使用してプロジェクトのコンテナを起動します。


```bash
docker-compose up --build
```

## 2. サービスの確認 

以下のURLをブラウザで開き、サービスが正常に起動しているか確認します。
 
- [http://localhost:8080/](http://localhost:8080/)
 
- [http://localhost:8081/](http://localhost:8081/)

# SQLファイルの一括フォーマット 

プロジェクト内のすべてのSQLファイルを一括でフォーマットするには、プロジェクトフォルダのルートディレクトリで以下のコマンドを実行します。IntelliJのFile Watchersなどに設定して自動化することもできます。


```bash
npx prettier --write "**/*.sql"
```

これにより、プロジェクト内のすべてのSQLファイルがPrettierによってフォーマットされます。  
さらに、SQLファイルのフォーマット設定をカスタマイズするために、`prettier.config.js`ファイルでSQLフォーマットに関する設定を行い、プロジェクト全体に適用することが可能です。

# IntelliJでのリモートデバッグ設定 

プロジェクトには、複数のサービスをリモートデバッグするためのIntelliJの設定ファイルが含まれています。この設定により、Dockerコンテナ内で動作するサービスを効率的にデバッグすることが可能です。

### 設定ファイル 
リモートデバッグ設定ファイルは、プロジェクトのルートディレクトリにある`.run`フォルダに配置されています。 
- `Docker Remote Debug - Service1.run.xml`
 
- `Docker Remote Debug - Service2.run.xml`
 
- `Multi-Service Debug.run.xml`

### 使用方法 
 
1. **IntelliJを開き、プロジェクトをロード** : 設定ファイルが適切に配置されていると、IntelliJの`Run/Debug Configurations`で「Multi-Service Debug」や「Docker Remote Debug - Service1」「Docker Remote Debug - Service2」が表示されます。
 
2. **「Multi-Service Debug」設定を選択** : 複数のサービスを同時にリモートデバッグするための設定が自動でロードされます。
 
3. **リモートデバッグを開始** : Dockerコンテナ上で動作している`Service1`と`Service2`を同時にデバッグできます。

これにより、複数のサービスを効率的にデバッグできる環境が整います。必要に応じて、各サービスの設定をカスタマイズすることも可能です。

