FROM openjdk:16
EXPOSE 8080
COPY /target/springboot.jar springboot.jar
ENTRYPOINT ["java","-jar","/springboot.jar"]