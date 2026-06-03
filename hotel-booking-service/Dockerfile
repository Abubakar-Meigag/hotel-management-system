# Stage 1 - Build
FROM maven:3.9-eclipse-temurin-25 AS build
WORKDIR /app

# Copy root pom.xml
COPY pom.xml .

# Copy all module pom.xml files so Maven knows they exist
COPY hotel-common/pom.xml hotel-common/pom.xml
COPY hotel-room-service/pom.xml hotel-room-service/pom.xml
COPY hotel-booking-service/pom.xml hotel-booking-service/pom.xml
COPY hotel-guest-service/pom.xml hotel-guest-service/pom.xml
COPY hotel-housekeeping-service/pom.xml hotel-housekeeping-service/pom.xml
COPY hotel-billing-service/pom.xml hotel-billing-service/pom.xml
COPY hotel-notification-service/pom.xml hotel-notification-service/pom.xml
COPY hotel-api-gateway/pom.xml hotel-api-gateway/pom.xml

# Copy source code
COPY hotel-common/src hotel-common/src
COPY hotel-booking-service/src hotel-booking-service/src

RUN mvn clean install -pl hotel-common -am -DskipTests
RUN mvn clean package -pl hotel-booking-service -DskipTests

# Stage 2 - Run
FROM eclipse-temurin:25-jre
WORKDIR /app
COPY --from=build /app/hotel-booking-service/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]