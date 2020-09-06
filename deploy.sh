#!/bin/bash

docker stop springboot
docker rm springboot

git pull

docker build -t oop/airquality:AirQuality-0.0.1-SNAPSHOT .
docker run -d --name springboot -p 8080:8080 oop/airquality:AirQuality-0.0.1-SNAPSHOT

