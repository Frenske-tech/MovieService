FROM openjdk:17
EXPOSE 8080
COPY /target/springboot.jar springboot.jar
ENTRYPOINT ["java","-jar","/springboot.jar"]