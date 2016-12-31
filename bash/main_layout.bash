#!/bin/bash

# Script description

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
      (--help|usage)
        usage
        exit 0
        ;;
      (*)
        usage
        exit 1
        ;;
    esac
  done
}

function usage()
{
  printf "%b" "

Usage:

  dotter [options]

Options

  [[--]backup]

  Backup the files on this machine to versino control.

  [[--]update]

    Update the files on this machine with the files from version control.

"
}

# Call main after all functions are set up
# Pass all the params to the main function
main "$@"
