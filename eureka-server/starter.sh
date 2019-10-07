#!/bin/bash
while ! (nc -z config-server 8888 && nc -z rabbitmq 15672); do sleep 3; echo 'Waiting for config-server and rabbitmq to start-up...'; done
java -jar -Dspring.profiles.active=stage -Dspring.cloud.config.uri=http://config-server:8888 eureka-server-1.0-SNAPSHOT.jar
