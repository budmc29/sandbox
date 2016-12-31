#!/bin/bash

# Function test

function main()
{
  one
  two
  with_arg
  with_arg 'argument'
  all_args 1 2 3 4 5
}

function one()
{
  echo 'one'
}

function two()
{
  echo 'two'
}

function with_arg()
{
  if [ $1 ]; then
    echo $1
  else
    echo 'no argument'
  fi
}

function all_args()
{
  while
    (($# > 0))
  do
    echo $1
    shift # removes the argument from the list
  done
}

# broken syntax
# function nil() {
# }

main
