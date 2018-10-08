#!/bin/bash

docker build -t frontend .

docker run --rm -p 4200:4200 frontend