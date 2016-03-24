#!/bin/bash

for file_name in ~/work/jmeter-ec2-tests/jmeter-account-test-*/results/; do
  ls -1t $file_name | head -1; 
done
