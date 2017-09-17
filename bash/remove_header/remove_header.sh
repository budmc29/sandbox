#/usr/bin/env bash

FILES=$*
REGEX=$(cat regex)

for file in $FILES
do
  INPUT="regex"
  while IFS= read -r line
  do
    sed -i "/$line/d" $file
  done <"$INPUT"
done
