#!/bin/bash

# Parse received parameters

function main()
{
  parse_params "$@"
}

function parse_params()
{
  while
    (( $# > 0 ))
  do
    PARAM="$1"
    shift
    case "$PARAM" in
      (--main|main|m)
        echo 'main use'
        ;;
      (*)
        echo 'usage'
        exit 1
        ;;
    esac
  done
}

main "$@"
