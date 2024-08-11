# Amazon Corretto 21 をベースイメージとして使用
FROM amazoncorretto:21

# 作業ディレクトリを作成
WORKDIR /app

# Gradle Wrapper をコピー
COPY gradlew gradlew.bat ./
COPY build.gradle settings.gradle ./
COPY gradle ./gradle

# 必要な依存関係をダウンロード
RUN ./gradlew build --no-daemon -x test

# プロジェクトのソースコードをコピー
COPY . .

# プロジェクトをビルド
RUN ./gradlew build --no-daemon

# Spring Boot アプリケーションを実行
CMD ["java", "-jar", "build/libs/app.jar"]

