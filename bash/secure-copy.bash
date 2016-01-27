#!/bin/bash

# Secure copy file via ssh

# copy file to the root
scp file_name user@sshmachine.com:

# copy folder to the root
scp -r folder_name/ user@sshmachine.com:

# copy in another folder
scp -r folder/ user@machine:/foler/another_folder


