#!/bin/bash

docker-compose down

git pull

docker-compose build
docker-compose up
