#!/bin/bash

# send get request with curl

curl -i -H "Accept: application/json" -G "Content-Type: application/json" -X GET https://website.com/api/2/login?email=email@domain&password=123456&device_id=123456

