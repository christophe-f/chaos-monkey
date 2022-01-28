#!/bin/bash

export CONTAINER_ID=$(docker ps | grep beer-service | awk -F " " '{print $1}')

echo "Enabling Chaos Monkey for Spring Boot..."
docker exec -it "$CONTAINER_ID" curl -X POST http://localhost:8081/actuator/chaosmonkey/enable
