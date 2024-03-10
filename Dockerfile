FROM maven:3.8.5-openjdk-17 AS build
COPY . .

FROM openjdk:17.0.1-jdk-slim
RUN ls /bin
COPY --from=build /target/SciCalc-backend-0.0.1-SNAPSHOT.JAR SciCalc-backend.jar
EXPOSE 8080
ENTRYPOINT [ "java","-jar","SciCalc-backend" ]