swagger-codegen-templates
=========================
Prerequisite to this is to have [scala](http://www.scala-lang.org/download/) and java installed on your host.  Scala needs to be on your path as well.

To generate java clients to swagger-enabled APIs, 

1. clone the swagger codegen project, [a small modification to swagger-codegen](https://github.com/swps/swagger-codegen)
2. Build the codegen project (sbt assembly)
3. clone this project 
4. ensure bin/newgen.sh references the codegen project accurately
5. modify java-gradle/config/IsftServiceClient.java to reflect the project you want to generate as well as where to generate it
6. Start your service.  Visit the swagger API docs for your service. 
7. generate! ./bin/newgen.sh java-gradle/config/IsftServiceClient.scala http://localhost:8080/api-docs 


This depends on a [small change to swagger codegen](https://github.com/swagger-api/swagger-codegen/pull/323), 
though the templates could be rewritten to not need it.

Look in [java-gradle/config/IsftServiceClient.scala](https://github.com/swps/swagger-codegen-templates/blob/master/java-gradle/config/IsftServiceClient.scala) for the configuration overrides.  In that, notice a few extra overrides not
identified in the public docs: `apiTemplateFiles` and `additionalParams`.

Of course, the list of supporting files is dramatically different.  Many of the gradle conventions are specific to my org,
but vanilla gradle build files are easy enough to substitute.

If you find this helpful or interesting, let me know: @DietSodaSoft
