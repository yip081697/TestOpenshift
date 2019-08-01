#bin/bash

#set current directory to that of script
cd $(dirname $0) 

#run code generator
java -jar ../../CodeGen/light-codegen/codegen-cli/target/codegen-cli.jar -f openapi -o .. -m ./openapi.yaml -c ./config.json