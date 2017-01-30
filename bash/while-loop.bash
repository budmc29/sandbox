#!/bin/bash --login

# while loop
i="0"
while [[ $i -lt 10 ]] ; do
  touch "file$i"; i=$[$i+1];
done
