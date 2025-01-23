FROM maven:3.9.9-eclipse-temurin-17 AS builder
WORKDIR /app

COPY . .
RUN mvn clean package -DskipTests

FROM eclipse-temurin:23-jdk
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8001
ENTRYPOINT ["java", "-jar", "app.jar"]
