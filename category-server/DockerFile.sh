##!/usr/bin/env bash
#FROM java:8
#MAINTAINER frontend-server
#COPY ./target/frontend-server-1.0-SNAPSHOT.jar frontend-server-1.0-SNAPSHOT.jar
#CMD ["java","-jar","frontend-server-1.0-SNAPSHOT.jar"]

FROM openjdk:jre-alpine
ARG VERSION=1.0.0
ADD ./target/cart-server-1.0-SNAPSHOT.jar cart-server-1.0-SNAPSHOT.jar
COPY ./starter.sh starter.sh
EXPOSE 8012
RUN apk add curl
RUN apk add --update --no-cache netcat-openbsd
RUN ["chmod", "+x", "starter.sh"]
ENTRYPOINT ["sh","starter.sh"]