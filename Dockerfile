FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD build/libs/*-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "/app.jar"]
EXPOSE 8080
