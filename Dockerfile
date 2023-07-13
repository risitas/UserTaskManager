FROM openjdk:17
LABEL maintainer="Yosimar <yosimarnaranjo9@gmail.com>"
COPY target/UserTaskManager-0.0.1-SNAPSHOT.jar userTaskManager-app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/userTaskManager-app.jar"]