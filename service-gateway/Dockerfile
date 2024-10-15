FROM openjdk:21-oracle

VOLUME /tmp

COPY target/*.jar  /gateway-service.jar

ENTRYPOINT ["java", "-jar","gateway-service.jar"]