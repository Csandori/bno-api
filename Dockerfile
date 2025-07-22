FROM openjdk:17-jdk-slim

WORKDIR /app

# Másoljuk a forráskódot
COPY . .

# Buildeljük a projektet (Maven Wrapper futtatásával)
RUN chmod +x ./mvnw
RUN ./mvnw package

# A buildelt JAR-t futtatjuk
CMD ["java", "-jar", "target/BnoApi-0.0.1-SNAPSHOT.jar"]