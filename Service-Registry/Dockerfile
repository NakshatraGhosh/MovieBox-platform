# Use OpenJDK 17 as base image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy the built jar file (replace with your jar name if different)
COPY target/Service-Registry-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your service runs on (change as needed)
EXPOSE 8761

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]