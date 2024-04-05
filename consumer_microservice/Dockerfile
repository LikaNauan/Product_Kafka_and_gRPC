FROM openjdk:17-alpine
WORKDIR /usr/src/consumermicroserviceapp

COPY pom.xml ./

COPY target/*.jar ./
EXPOSE 8002
CMD ["java", "-jar", "target/*.jar"]
