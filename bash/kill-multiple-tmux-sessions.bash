#!/bin/bash

echo "First tmux session"
read START

echo "Last tmux session"
read LAST

# start from this numbered window
counter=$START

# kill sessions from 10 to 33
while [ $counter -le $LAST ]; do
  tmux kill-session -t $counter
  let counter=counter+1
done
