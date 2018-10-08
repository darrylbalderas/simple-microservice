#!/bin/bash

docker build -t darryl3223/frontend .

docker push docker.io/darryl3223/frontend

# docker run --rm -p 4200:4200 darryl3223/frontend