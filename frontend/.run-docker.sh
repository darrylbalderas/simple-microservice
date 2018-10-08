#!/bin/bash

docker build -t angular-frontend .

docker run --rm -p 4200:4200 angular