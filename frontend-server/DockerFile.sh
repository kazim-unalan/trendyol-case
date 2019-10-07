FROM openjdk:jre-alpine
ARG VERSION=1.0.0
ADD ./target/frontend-server-1.0-SNAPSHOT.jar frontend-server-1.0-SNAPSHOT.jar
COPY ./starter.sh starter.sh
EXPOSE 8011
RUN apk add curl
RUN apk add --update --no-cache netcat-openbsd
RUN ["chmod", "+x", "starter.sh"]
ENTRYPOINT ["sh","starter.sh"]