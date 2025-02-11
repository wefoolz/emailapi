# Use an official Maven image to build the project
FROM maven:3.8.1-openjdk-17-slim AS builder

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml and the rest of the source code into the container
COPY pom.xml .

# Download dependencies (this is cached if unchanged)
RUN mvn dependency:go-offline

# Copy the rest of the source code
COPY src /app/src

# Build the app (it will create a JAR file in target/)
RUN mvn clean package -DskipTests

# Use an official OpenJDK image to run the application
FROM openjdk:17-jdk-slim

# Set the working directory for running the app
WORKDIR /app

# Copy the jar file from the builder stage
COPY --from=builder /app/target/emailapi-0.0.1-SNAPSHOT.jar /app/emailapi.jar

# Expose the port the app will run on
EXPOSE 8282

# Run the application
ENTRYPOINT ["java", "-jar", "emailapi.jar"]
