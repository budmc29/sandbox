#!/bin/bash

# kill sessions by id

# start from this numbered window
counter=10

# kill sessions from 10 to 33
while [ $counter -lt 33 ]; do
  tmux kill-session -t $counter
  let counter=counter+1
done
