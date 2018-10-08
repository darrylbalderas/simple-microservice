#!/bin/bash

gradle clean build

docker build -t backend .

docker run --rm --name backend -p 8080:8080 backend