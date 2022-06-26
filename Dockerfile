FROM openjdk:8
EXPOSE 5050
ADD target/spring-boot-crud-api.jar spring-boot-crud-api.jar
ENTRYPOINT ["java","-jar","/spring-boot-crud-api.jar"]