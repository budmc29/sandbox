#!/bin/bash

# check running process

if pgrep "tmux" > /dev/null
then
  echo "running"
else
  echo "not running"
fi
