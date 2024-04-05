FROM openjdk:17-alpine
WORKDIR /usr/src/productmicroserviceapp

COPY pom.xml ./

COPY target/*.jar ./
EXPOSE 8001
CMD ["java", "-jar", "target/*.jar"]
