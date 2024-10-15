FROM openjdk:21-oracle

VOLUME /tmp

COPY target/*.jar /account-service.jar

ENTRYPOINT ["java", "-jar","account-service.jar"]