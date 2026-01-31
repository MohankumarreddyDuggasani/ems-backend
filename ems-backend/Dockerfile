# Use Maven + JDK image
FROM maven:3.9.3-eclipse-temurin-17

# Set working directory
WORKDIR /app

# Copy only pom.xml first (to leverage Docker cache)
COPY pom.xml .

# Download dependencies only (speeds up builds)
RUN mvn dependency:go-offline -B

# Copy source code
COPY src ./src

# Build Spring Boot JAR
RUN mvn clean package -DskipTests

# Expose the port your app uses
EXPOSE 8080

# Run the Spring Boot JAR
ENTRYPOINT ["java", "-jar", "target/ems-backend-0.0.1-SNAPSHOT.jar"]