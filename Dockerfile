FROM openjdk:8-jre-alpine

EXPOSE 8080

COPY ./target/java-maven-app-1.1.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

CMD "java", "-jar", "java-maven-app-1.1.*-SNAPSHOT.jar"