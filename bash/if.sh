#!/bin/bash

echo "answer the question [y/n]"
read status

if [ "$status" != "y" ]; then
  echo "status is no"
fi
