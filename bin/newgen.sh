#!/bin/sh

# Run this from the swagger-codegen folder, which is a peer folder to this project

rm -rf ../swagger-codegen-isft/java-gradle-codegen/*
./bin/runscala.sh ../swagger-codegen-isft/config/IsftServiceClient.scala http://localhost:8080/api-docs

