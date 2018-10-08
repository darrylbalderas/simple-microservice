#!/bin/bash

gradle clean build

docker build -t java-backend .

docker run --rm -p 8080:8080 java-backend