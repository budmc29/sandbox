#!/bin/bash

echo "what is the process name"
read process_name

for process in `pgrep $process_name`; do
  kill $process
done
