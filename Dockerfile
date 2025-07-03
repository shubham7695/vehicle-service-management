FROM openjdk:17-jdk-slim

# Install netcat and mysql-client
RUN apt-get update && apt-get install -y netcat default-mysql-client && rm -rf /var/lib/apt/lists/*

WORKDIR /app

COPY target/vehicleServiceManagement-0.0.1-SNAPSHOT.jar app.jar
COPY wait-for-mysql.sh wait-for-mysql.sh

RUN chmod +x wait-for-mysql.sh

ENTRYPOINT ["./wait-for-mysql.sh"]
CMD ["java", "-jar", "app.jar"]
