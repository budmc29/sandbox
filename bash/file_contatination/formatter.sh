#!/usr/bin/env bash

index=0
file_name='all_bank_holidays.json'
echo '{' > $file_name
for file in bank_holidays_*; do
  year=$(echo "$file" | cut -d '_' -f 3)

  if [[ $index -gt 0 ]]; then
    echo "," >> $file_name
  fi

  echo "\"$year\": $(cat "$file")" >> $file_name
  cat $file_name

  index+=1
done
echo '}' >> $file_name

