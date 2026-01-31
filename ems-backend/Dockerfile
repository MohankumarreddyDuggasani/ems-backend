# Use Java 17 base image
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy pom.xml and mvnw first (cacheable)
COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn

# Give execute permission to mvnw
RUN chmod +x mvnw

# Download dependencies (optional, improves build caching)
RUN ./mvnw dependency:go-offline

# Copy the source code
COPY src ./src

# Build Spring Boot project (skip tests)
RUN ./mvnw clean package -DskipTests

# Expose Spring Boot default port
EXPOSE 8080

# Run the jar
CMD ["java", "-jar", "target/ems-backend-0.0.1-SNAPSHOT.jar"]