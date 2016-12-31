#!/bin/bash
shopt -s expand_aliases

if [[ -f "$1" ]]; then
  echo "The file was found"
else
  echo "The file was not found, please enter the correct path as the first parameter."
  exit
fi

items=(
  $awsstaging1host
  $awsstaging2host
  $awsstaging3host
  $awsstaging4host
  $awsstaging5host
)

for ssh_address in "${items[@]}" ; do
  echo ${ssh_address}:
done
