FROM openjdk:11
COPY . target/java-maven-app-1.1.0-SNAPSHOT.jar
COPY . /src/java
WORKDIR /src/main/java
RUN ["javac", "Application.java"]
ENTRYPOINT  ["java", "-jar", "java-maven-app-1.1.7.jar" ]
