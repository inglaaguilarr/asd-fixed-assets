FROM openjdk:11-jdk-slim
EXPOSE 8080
ARG JAR_FILE=target/asd.fixed.assets-1.0.0.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
