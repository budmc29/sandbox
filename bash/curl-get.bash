#!/bin/bash

# send get request with curl

curl -i -H "Accept: application/json" -G "Content-Type: application/json" -X GET httpbin.org/ip

