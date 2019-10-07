FROM openjdk:jre-alpine
ARG VERSION=1.0.0
ADD ./target/eureka-server-1.0-SNAPSHOT.jar eureka-server-1.0-SNAPSHOT.jar
COPY ./starter.sh starter.sh
EXPOSE 8761
RUN apk add curl
RUN apk add --update --no-cache netcat-openbsd
RUN ["chmod", "+x", "starter.sh"]
ENTRYPOINT ["sh","starter.sh"]