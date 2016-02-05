#!/bin/bash

# send post request with curl

curl -i -X POST -H "Accept: Application/json" -H "Content-Type: application/json" https://site.com/api/2/login -d '{"email":"user@domain.com","password":123456, "device_id":123456}'

# -L is the location flag
