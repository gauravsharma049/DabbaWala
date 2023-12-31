FROM maven:3.8.3-openjdk-17 AS build
WORKDIR /app
COPY . /app/
RUN mvn clean package

FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar /app/dabbawala.jar
EXPOSE 80
ENTRYPOINT ["java","-jar","/app/dabbawala.jar"]