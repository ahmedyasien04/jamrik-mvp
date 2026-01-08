# Step 1: Use Java 21 to build the app
FROM eclipse-temurin:21-jdk-alpine as build
WORKDIR /app

# Step 2: Copy maven files
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
# This makes the 'mvnw' file executable in Linux (Docker)
RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline

# Step 3: Copy source and build
COPY src ./src
RUN ./mvnw clean package -DskipTests

# Step 4: Run the app using the lightweight JRE 21
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT java", "-jar", "app.jar
