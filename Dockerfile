FROM openjdk:11
EXPOSE 8080
COPY . target/java-maven-app-1.1.0-SNAPSHOT.jar /usr/app/
#COPY . /usr/app
WORKDIR /usr/app
#RUN ["javac", "Application.java"]
ENTRYPOINT  ["java", "-jar", "java-maven-app-1.1.0-SNAPSHOT.jar"]
