#!/bin/bash

# rename file recursive in a folder
find test -type f -name '*.ext1' -print0 | xargs -0 rename 's/.ext2$/.ext2/'

