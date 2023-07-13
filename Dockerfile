FROM openjdk:17
LABEL maintainer="Yosimar <yosimarnaranjo9@gmail.com>"
COPY target/UserTaskManager-0.0.1-SNAPSHOT.jar UserTaskManager-app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/UserTaskManager-app.jar"]