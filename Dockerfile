FROM openjdk:11-jdk-slim

ADD target/teams-service-0.0.1-SNAPSHOT.jar teams-service-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/teams-service-0.0.1-SNAPSHOT.jar"]

EXPOSE 8082