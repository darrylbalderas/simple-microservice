# simple-microservice

Backend is a gradle project using spring boot and java


Frontend is angular cli project using angular 5 and typescript


This project main purpose is to show how easy it is to deploy services on kubernetes

We will be using kubernetes locally provide with docker

## Prerequisetes

Install [docker](https://docs.docker.com/)

Install [gradle](https://gradle.org/)
* MacOs Example: `brew install gradle`

Install [node and npm] (https://nodejs.org/en/)
* MacOs Example: `brew install node`


# Running projects

* Change directory into backend/frontend

* Run this file `./run-docker.sh`
    * This file will create the docker image, deploy to a dockerhub account, create deployment & services in kubernetes environment, and then port forward your service to localhost:specified-port


