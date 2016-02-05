#!/bin/bash

# seng a get request 100 time to the website
value=0

while [ "$value" -lt 10000 ]; do
  curl --request GET 'https://accountsstageaws.yoyogames.com/login'
done
