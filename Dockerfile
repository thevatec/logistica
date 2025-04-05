FROM openjdk:21
COPY target/logistica-0.0.1-SNAPSHOT.jar logistica-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/logistica-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080