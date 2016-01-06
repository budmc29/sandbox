#!/bin/bash

# send get request with curl

curl -i -X POST -H "Accept: Application/json" -H "Content-Type: application/json" httpbin.org/post -d '{"email":"mail@example.com","password":"123456", "remember":"true"}'
