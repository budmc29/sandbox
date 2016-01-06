#!/bin/bash

command -v wget >/dev/null 2>&1 || { echo >&2 "wget is not installed"; exit 1; }

command -v gibberish >/dev/null 2>&1 || { echo >&2 "gibberish is not installed"; exit 1; }

