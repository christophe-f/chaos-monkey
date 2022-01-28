#!/bin/bash

cd ../docker

echo "Rebuilding the client service..."
docker-compose build client-service

echo "Restarting client-service container..."
docker-compose restart client-service
