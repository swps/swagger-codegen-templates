swagger-codegen-templates
=========================
Prerequisite to this is to have (scala)[http://www.scala-lang.org/download/] and java installed on your host.  Scala needs to be on your path as well.

To generate java clients to swagger-enabled APIs, 
1. clone this project and (a small modification to swagger-codegen)[https://github.com/swps/swagger-codegen]. Build the codegen project (sbt assembly)
2. ensure bin/newgen.sh references the codegen project accurately
3. modify java-gradle/config/IsftServiceClient.java to reflect the project you want to generate as well as where to generate it
4. from this project's root folder, ./bin/newgen.sh java-gradle/config/IsftServiceClient.scala <url of swagger service>

This depends on a [small change to swagger codegen](https://github.com/swagger-api/swagger-codegen/pull/323), 
though the templates could be rewritten to not need it.

Look in [java-gradle/config/IsftServiceClient.scala](https://github.com/swps/swagger-codegen-templates/blob/master/java-gradle/config/IsftServiceClient.scala) for the configuration overrides.  In that, notice a few extra overrides not
identified in the public docs: `apiTemplateFiles` and `additionalParams`.

Of course, the list of supporting files is dramatically different.  Many of the gradle conventions are specific to my org,
but vanilla gradle build files are easy enough to substitute.

If you find this helpful or interesting, let me know: @DietSodaSoft
