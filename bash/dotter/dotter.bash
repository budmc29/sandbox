#!/bin/bash

# Backup all the specified files to version control, or update the files on
#   this machine with the ones available online.

function main()
{
  parse_params "$@"
  usage
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

main "$@"
