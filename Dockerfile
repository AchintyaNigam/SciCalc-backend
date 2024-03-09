FROM maven:3.8.4 AS build
WORKDIR /SciCalc-backend
COPY . .
RUN mvn clean package

FROM openjdk:17.0.2-jdk-slim
WORKDIR /SciCalc-backend
COPY --from=build /SciCalc-backend/target/SciCalc-backend-0.0.1-SNAPSHOT.jar /app/SciCalc-backend.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/SciCalc-backend/target/SciCalc-backend.jar"]