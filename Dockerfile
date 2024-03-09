FROM openjdk:17.0.2-jdk-slim AS build
WORKDIR /app
COPY . .
RUN mvn clean package

FROM openjdk:17.0.2-jdk-slim
COPY --from=build /SciCalc-backend/target/SciCalc-backend-0.0.1-SNAPSHOT.jar /app/SciCalc-backend.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/SciCalc-backend.jar"]