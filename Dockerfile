FROM openjdk:17
EXPOSE 8080
COPY /target/MovieCrud-0.0.1-SNAPSHOT.jar MovieCrud-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/springboot.jar"]