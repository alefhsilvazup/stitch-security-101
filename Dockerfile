FROM openjdk:12-jdk-alpine

WORKDIR /app

COPY target/spring-security-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8095

ENTRYPOINT ["java",  "-jar", "app.jar"]