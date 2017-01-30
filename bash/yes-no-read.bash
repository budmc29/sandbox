#!/bin/bash --login

# script name
RESP=
while [ -z "$RESP" ] ; do
  echo "Are you in the folder of the repository you want to initate?"

  read RESP

  case "$RESP" in
    [yY]|[yY][eE][sS])

      ;;
    *)
      echo "Change directory to the new project and call the script again"
      exit
  esac
done
