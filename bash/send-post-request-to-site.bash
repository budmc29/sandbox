#!/bin/bash

# seng a get request 100 time to the website
counter=0

while [ "$counter" -lt 10000 ]; do
  curl -i -X POST https://accountsstageaws.yoyogames.com/sessions -d '{"email":"email", "password":"pass"}'
  let counter=counter+1
done
