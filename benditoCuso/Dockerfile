FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/benditoCuso-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app_benditocuso.jar
EXPOSE 8080
LABEL authors="nicom"

ENTRYPOINT ["java", "-jar", "app_benditocuso.jar"]