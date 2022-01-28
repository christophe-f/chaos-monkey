#!/bin/bash

echo "Stopping all Demo Containers..."
cd ../docker
docker-compose down --volumes
