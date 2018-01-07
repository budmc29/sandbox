#!/usr/bin/env bash

function main() {
  respond "$@"

  exit 0
}

function respond() {
  MESSAGE_TYPE=$(parse_message "$*");

  case "$MESSAGE_TYPE" in
    "default")
      default_response;
      ;;
    "shout")
      shout_response;
      ;;
    "question")
      question_response;
      ;;
    "silence")
      silence_response;
      ;;
  esac
}

function parse_message() {
  MESSAGE="$*";
  LAST_CHARACTER=$(echo -n ${MESSAGE//[:space:]/''} | tail -c 1)
  echo $LAST_CHARACTER
  CLEANED_MESSAGE=${MESSAGE//[^a-zA-Z]/''}

  if [[ "$CLEANED_MESSAGE" =~ ^[A-Z[:space:]]+\?*$ ]]; then
    echo 'shout';
  elif [[ "$LAST_CHARACTER" =~ \? ]]; then
    echo 'question';
  elif [[ "$MESSAGE" =~ ^[[:blank:]]*$ ]]; then
    echo 'silence';
  else
    echo 'default';
  fi
}

function default_response() {
  echo "Whatever.";
}

function shout_response() {
  echo "Whoa, chill out!";
}

function question_response() {
  echo "Sure.";
}

function silence_response() {
  echo "Fine. Be that way!";
}

main "$@"
