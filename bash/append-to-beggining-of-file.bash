#!/bin/bash

# add text to the beginning of the file

# $@ takes all parameters
parameter=$@
sed -i "/# 1.TODO/a * [ ] ${parameter}" test.txt
