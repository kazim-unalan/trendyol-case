#!/bin/bash
while ! (nc -z config-server 8888 && nc -z eureka-server 8761 && nc -z rabbitmq 15672 && nc -z hystrix-dashboard-server 7979); do sleep 3; echo 'Waiting for config-server and eureka-server and hystrix-dashboard-server and rabbitmq to start-up...'; done
java -jar -Dspring.profiles.active=stage -Dspring.cloud.config.uri=http://config-server:8888 order-server-1.0-SNAPSHOT.jar