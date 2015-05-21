#!/bin/sh

# Run this from the project root folder, where the swagger-codegen project is at the location specified here
swaggerCodegen=../swagger-codegen-fork


if [ ! -d $swaggerCodegen ]; then

    echo "Verify location of Swagger's Code Generation fork."
    echo "$swaggerCodegen does not exist."
    echo
    exit 1

fi

pwd=`pwd`
pushd $pwd

case "x$1" in
  "x") serviceLocation="http://localhost:8080/api-docs" ;;
  *)   serviceLocation=$1                               ;;
esac

cd $swaggerCodegen


serviceConfig=$pwd/java-gradle/config/IsftServiceClient.scala
targetFolder=$(grep "def destinationProjectDir" $serviceConfig|cut -d '"' -f 2)


if [ -d $targetFolder ]; then

  read -r -p "Delete all files and folders located at $targetFolder? [y/N] " response
  case $response in
      [yY][eE][sS]|[yY]) 
          echo "Removing previous generated project located at '$targetFolder'"
          rm -rf $targetFolder/*
          echo
          echo
          ;;
      *)
          echo "Aborting."
          echo
          exit 1
          ;;
  esac

fi


if [ -e "$targetFolder/*" ]; then

          echo "Destination folder for generated SDK is not empty.  Aborting."
          echo
          exit 1

fi

echo
echo "Creating SDK for service $serviceLocation at $targetFolder"
echo

cmd="./bin/runscala.sh $pwd/java-gradle/config/IsftServiceClient.scala http://localhost:8080/api-docs"
rc=eval $cmd

chmod 755 "$targetFolder/gradlew"

echo "Finished with $rc"
popd
