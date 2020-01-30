FROM openjdk:8-jre-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} publisher-rabbit.jar
ENTRYPOINT ["java","-jar","/publisher-rabbit.jar"]
EXPOSE 8080