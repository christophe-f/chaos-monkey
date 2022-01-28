#!/bin/bash

echo "Starting Docker Containers..."
cd ../docker
docker-compose up -d

echo "****************************************************"
echo "* Prometheus is available at http://localhost:9090 *"
echo "* Grafana is available at http://localhost:3000    *"
echo "* Locust is available at http://localhost:8089     *"
echo "****************************************************"
