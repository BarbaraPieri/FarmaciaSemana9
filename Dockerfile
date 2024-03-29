# Imagem suporte Java
FROM openjdk:11

WORKDIR /app

COPY target/API-0.0.1-SNAPSHOT.jar /app/API-0.0.1-SNAPSHOT.jar

ENV DB_URL jdbc:mysql://localhost:3306/senac_api
ENV DB_USERNAME root
ENV DB_PASSWORD 9_NhBgXr14@2

EXPOSE 8080

CMD ["java", "-jar", "API-0.0.1-SNAPSHOT.jar"]
