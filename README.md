# cloneの前に
※windowsユーザーの場合
```bash
git config --global core.autocrlf input
```

# 起動方法

## 1. MySQLクライアントのインストール

まず、ローカルマシンにMySQLクライアントがインストールされていることを確認します。インストールされていない場合、以下の手順に従ってインストールを行ってください。

### Windows

Windowsでは、MySQLに接続するためにMySQL Workbenchを使用するのが一般的です。MySQL Workbenchがインストールされていない場合、以下の手順でインストールします。

1. [MySQL公式サイト](https://dev.mysql.com/downloads/workbench/)からMySQL Workbenchをダウンロードします。
2. インストーラーを実行し、指示に従ってインストールを完了させます。

### macOS

macOSでは、Homebrewを使用してMySQLクライアントをインストールできます。ターミナルで以下のコマンドを実行してください。

```bash
brew install mysql
```

## 2. Docker Composeでコンテナを起動
```bash
docker-compose up --build
```

# いろいろ確認
http://localhost:8080/  
http://localhost:8081/
