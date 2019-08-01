#bin/bash

#set current directory to that of script
cd $(dirname $0) 

docker build -t test-light-hello -f docker/Dockerfile .