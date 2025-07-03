# ---------- STAGE 1: Build with Maven ----------
FROM maven:3.9.6-eclipse-temurin-17 AS builder

WORKDIR /app

# Copy pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy source code
COPY src ./src

# Build the JAR
RUN mvn clean package -DskipTests

# ---------- STAGE 2: Run the app ----------
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy the JAR from the builder stage
COPY --from=builder /app/target/vehicleServiceManagement-0.0.1-SNAPSHOT.jar app.jar

# Optional: if you're using wait-for-mysql.sh
COPY wait-for-mysql.sh wait-for-mysql.sh
RUN chmod +x wait-for-mysql.sh

CMD ["java", "-jar", "app.jar"]
