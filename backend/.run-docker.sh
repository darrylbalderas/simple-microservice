#!/bin/bash

gradle clean build

docker build -t java-backend .

docker run --rm --name java-backend -p 8081:8081 java-backend