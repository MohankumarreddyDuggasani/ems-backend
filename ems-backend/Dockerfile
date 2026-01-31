# Use Java 17 base image
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy pom.xml and mvnw first for caching
COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn

# Install dependencies (optional, improves caching)
RUN ./mvnw dependency:go-offline

# Copy source code
COPY src ./src

# Build Spring Boot jar
RUN ./mvnw clean package -DskipTests

# Expose default Spring Boot port
EXPOSE 8080

# Run the jar
CMD ["java", "-jar", "target/ems-backend-0.0.1-SNAPSHOT.jar"]