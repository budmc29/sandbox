#!/bin/bash

# seng a get request 100 time to the website
counter=0

while [ "$counter" -lt 100000 ]; do
  curl -i -H "Accept: application/html" -G "Content-Type: application/html" -X GET https://accountsstageaws.yoyogames.com/login
  let counter=counter+1
done
