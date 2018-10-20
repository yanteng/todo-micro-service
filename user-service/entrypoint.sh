#!/bin/sh
while ! nc -z config-service 8888 ; do
    echo "Waiting for upcoming Config Service"
    sleep 2
done
java -jar /app.jar