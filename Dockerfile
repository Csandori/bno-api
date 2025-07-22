FROM openjdk:17-jdk-slim

WORKDIR /app

# Másoljuk a forráskódot
COPY . .

# Buildeljük a projektet (Gradle Wrapper futtatásával)
RUN ./gradlew build --no-daemon

# A buildelt JAR-t futtatjuk
CMD ["java", "-jar", "build/libs/bno-api-0.0.1-SNAPSHOT.jar"]
