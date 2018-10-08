#!/bin/bash

docker build -t java-backend .

docker run --rm -p 8080:8080 java-backend