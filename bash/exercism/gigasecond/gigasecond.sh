#!/usr/bin/env bash

# Calculates the moment when someone has lived for 10^9 seconds
# (Gigasecond)
function main() {
  validate_input $@;

  calculate_gigasecond $@

  exit 0
};

function validate_input() {
  if ! [ "$#" > 1 ]; then
    echo "Usage: ./gigasecond DATE";
    exit 1
  fi
}

function calculate_gigasecond() {
  DATE="$*";
  DATE_IN_SECONDS=$(date -d "$DATE" +%s)
  GIGASECOND=1000000000
  GIGASECOND_DATE=$(($DATE_IN_SECONDS + $GIGASECOND))

  timestamp_to_date $GIGASECOND_DATE;
}

function timestamp_to_date() {
  echo $(date -u -d @$1);
}

main $@
