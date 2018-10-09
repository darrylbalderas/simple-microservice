#!/bin/bash

# Creates jar file
gradle clean build

#Create backend image
docker build -t darryl3223/backend .

# Pushing docker image to docker hub
docker push docker.io/darryl3223/backend

# Running on local kubernetes cluster 
# Create statefulset and service
kubectl apply -f deployment.yaml

# Wait for pod to start up
echo "Wait for pod to startup"
sleep 6

# Port forward backend service to localhost:4200
kubectl port-forward backend-0 8080:8080

# Running locally
# docker run --rm --name backend -p 8080:8080 darryl3223/backend