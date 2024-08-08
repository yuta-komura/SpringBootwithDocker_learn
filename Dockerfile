# ビルドステージ
FROM amazoncorretto:21 AS build

# 作業ディレクトリを作成
WORKDIR /app

# Gradle Wrapper をコピー
COPY gradlew gradlew.bat ./
COPY build.gradle settings.gradle ./
COPY gradle ./gradle

# 必要な依存関係を事前にダウンロード（キャッシュレイヤーを利用）
RUN ./gradlew --version
RUN ./gradlew build --no-daemon -x test

# プロジェクトのソースコードをコピー
COPY src ./src
COPY . .

# プロジェクトをビルド
RUN ./gradlew build --no-daemon

# 実行ステージ
FROM amazoncorretto:21

# 作業ディレクトリを作成
WORKDIR /app

# ビルドステージからビルドされた JAR ファイルをコピー
COPY --from=build /app/build/libs/app.jar ./app.jar

# Spring Boot アプリケーションを実行
CMD ["java", "-jar", "./app.jar"]
