FROM openjdk:jre-alpine
ADD ./target/config-server-1.0-SNAPSHOT.jar config-server-1.0.0.jar
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=stage", "config-server-1.0.0.jar"]
EXPOSE 8888