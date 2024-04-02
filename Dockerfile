FROM openjdk:17

WORKDIR /app

COPY target/API-0.0.1-SNAPSHOT.jar /app/API-0.0.1-SNAPSHOT.jar

EXPOSE 8080

CMD ["java", "-jar", "API-0.0.1-SNAPSHOT.jar"]

