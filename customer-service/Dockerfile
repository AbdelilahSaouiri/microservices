FROM openjdk:21-oracle

VOLUME /tmp

COPY  target/*.jar  /customer-service.jar

ENTRYPOINT ["java","-jar","customer-service.jar"]