#Multi-staged Docker

FROM maven:3-amazoncorretto-17 as build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline

COPY src/ ./src
RUN mvn clean package

FROM amazoncorretto:17-alpine

RUN apk add --no-cache \
        openssh \
        curl

RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

COPY --from=build /app/target/*.jar /app.jar
EXPOSE 8080

ENV LOG4J_FORMAT_MSG_NO_LOOKUPS=true
ENTRYPOINT ["java","-jar","/app.jar"]