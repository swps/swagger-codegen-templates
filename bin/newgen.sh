#!/bin/sh

# Run this from the project root folder, where the swagger-codegen project is at the location specified here
swaggerCodegen=../swagger-codegen-fork


pwd=`pwd`
pushd $pwd

cd $swaggerCodegen

serviceConfig=$pwd/java-gradle/config/IsftServiceClient.scala
targetFolder=$(grep "def destinationProjectDir" $serviceConfig|cut -d '"' -f 2)

if [ -d $targetFolder ]; then
  echo "Removing previous generated project located at '$targetFolder'"
  rm -rf $targetFolder/*
  echo
  echo
fi


cmd="./bin/runscala.sh $pwd/java-gradle/config/IsftServiceClient.scala http://localhost:8080/api-docs"
rc=eval $cmd

echo "Finished with $rc"
popd
