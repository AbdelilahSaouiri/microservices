FROM openjdk:21-oracle

VOLUME /tmp
COPY  target/*.jar   /discouvery-service.jar

ENTRYPOINT ["java", "-jar","discouvery-service.jar"]