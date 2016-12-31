#!/bin/bash

# Script description

STRING="string"
VAR1="var1"
VAR2="var2"
VAR3="var3"

function main()
{
  echo $STRING$VAR1

  echo $STRING${VAR2}

  echo ${VAR3}${VAR2}

  echo ${VAR1}"test"

  echo "test${VAR3}test"
}

main
