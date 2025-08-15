FROM openjdk:21-jdk
LABEL authors="axzarian"
COPY build/libs/football-test-app-0.0.1-SNAPSHOT.jar footbal-app.jar
ENTRYPOINT ["java","-jar","/footbal-app.jar"]
