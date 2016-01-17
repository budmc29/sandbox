#!/bin/bash

# add text to the beginning of the file

parameter=$1
sed -i "/# 1.TODO/a * [ ] ${parameter}" test.txt
