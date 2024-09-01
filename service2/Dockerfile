# Amazon Corretto 21 をベースイメージとして使用
FROM amazoncorretto:21

# 作業ディレクトリを作成
WORKDIR /app

# プロジェクトの必要なファイルを最初にコピー
COPY build.gradle settings.gradle gradlew ./
COPY gradle ./gradle

# 依存関係のダウンロード（キャッシュを有効にするため）
RUN ./gradlew build --no-daemon -x test

# 残りのプロジェクトをコピー
COPY . .

# プロジェクトをビルド（テストを実行）
RUN ./gradlew build --no-daemon

# Spring Boot アプリケーションを実行
CMD ["java", "-jar", "build/libs/app.jar"]
