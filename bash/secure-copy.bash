#!/bin/bash

# Secure copy file via ssh

# copy file to the root
scp file_name user@sshmachine.com:

# copy folder to the root
scp -r folder_name/ user@sshmachine.com:

# copy in another folder
scp -r folder/ user@machine:folder/another_folder

# use identity file for ssh connection
scp -r -i ~/.ssh/marketplace folder_name/ user@host:foder/subfolder

# scp from server to local machine root
scp user@sshmachine:file_name ~/
