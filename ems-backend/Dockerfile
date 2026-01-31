# Use JDK 17
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy Maven wrapper and pom.xml first (for caching dependencies)
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Make Maven wrapper executable
RUN chmod +x mvnw

# Download dependencies (offline)
RUN ./mvnw dependency:go-offline -B

# Copy source code
COPY src ./src

# Build Spring Boot project (skip tests)
RUN ./mvnw clean package -DskipTests

# Expose default Spring Boot port
EXPOSE 8080

# Run the jar
# The jar name must match your Maven artifactId and version
CMD ["java", "-jar", "target/ems-backend-0.0.1-SNAPSHOT.jar"]