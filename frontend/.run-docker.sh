#!/bin/bash

#Create frontend image
docker build -t darryl3223/frontend .

# Pushing docker image to docker hub
docker push docker.io/darryl3223/frontend

# Running on local kubernetes cluster 
# Creates statefulset and service
kubectl apply -f deployment.yaml

# Wait for pod to start up
echo "Wait for pod to startup"
sleep 6

# Port forward frontend service to localhost:4200
kubectl port-forward frontend-0 4200:4200

# Running locally
# docker run --rm --name frontend -p 4200:4200 darryl3223/frontend