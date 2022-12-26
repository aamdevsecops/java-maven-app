FROM openjdk:8-jre-alpine

EXPOSE 8080

RUN mkdir /usr/app
WORKDIR /usr/app
COPY ./target/java-maven-app-1.1.1-SNAPSHOT.jar /usr/app


CMD java -jar java-maven-app-*.jar