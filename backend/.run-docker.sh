#!/bin/bash

gradle clean build

docker build -t darryl3223/backend .

#Make sure you login into docker.io  =>  docker login docker.io
docker push docker.io/darryl3223/backend

# docker run --rm --name backend -p 8080:8080 darryl3223/backend