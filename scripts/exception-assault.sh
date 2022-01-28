#!/bin/bash

export CONTAINER_ID=$(docker ps | grep beer-service | awk -F " " '{print $1}')

echo "Enabling Exceptions Assault..."
docker exec -it "$CONTAINER_ID" curl -X POST \
                                      http://localhost:8081/actuator/chaosmonkey/assaults \
                                      -H 'Content-Type: application/json' \
                                      -d ' {
                                        "level": 10,
                                        "latency_range_start": 2000,
                                        "latency_range_end": 5000,
                                        "latency_active": false,
                                        "exceptions_active": true
                                        }'
