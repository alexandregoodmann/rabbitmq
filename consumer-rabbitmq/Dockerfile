FROM openjdk:8-jre-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} consumer-rabbit.jar
ENTRYPOINT ["java","-jar","/consumer-rabbit.jar"]