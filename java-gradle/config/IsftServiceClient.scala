import com.wordnik.swagger.codegen.BasicJavaGenerator

object IsftServiceClient extends BasicJavaGenerator {
  def main(args: Array[String]) = {
    generateClient(args)
  }

  // location of templates
  override def templateDir = "/Users/wendel.schultz/development/projects/infusionso/developer-services/swagger-codegen-isft/java-gradle"

  // where to write generated code
  def destinationProjectDir = "/Users/wendel.schultz/development/projects/infusionso/developer-services/swagger-codegen-isft/java-gradle-codegen"
  override def destinationDir = destinationProjectDir + java.io.File.separator + "src" + java.io.File.separator + "main" + java.io.File.separator + "java"

  // api invoker package
  override def invokerPackage = Some("com.infusionsoft.fieldmanual.client")

  // package for models
  override def modelPackage = Some("com.infusionsoft.fieldmanual.client.model")

  // package for api classes
  override def apiPackage = Some("com.infusionsoft.fieldmanual.client.endpoints")


  //  apiTemplateFiles += "api.ssp" -> ".java"
  apiTemplateFiles += "ApiHystrixDelegator.mustache" -> "HystrixDelegator.java"


  /**
   * you should override these params for generating the gradle files and processing
   * additional params
   **/
  additionalParams ++= Map(
    "artifactId" -> "field-manual-service-java-client",
    "artifactVersion" -> "1.0.0",
    "groupId" -> "com.infusionsoft",
    "pancakesVersion" -> "1.1.4.8",
    "pancakeFlavor" -> "infusionsoft-swagger-web-service-client-autogen"

    ,"serviceDescription" -> "A Simple Client for Field Manual Service - An Infusionsoft MicroApplication Client SDK"
    ,"artifactsUrl" -> "https://scm.infusiontest.com/nexus/content/repositories/builds/com/infusionsoft/field-manual-service-client/"
    ,"facadeClassName" -> "FieldManualService"
    ,"serviceName" -> "Field Manual Service"
  )

  // supporting classes
  override def supportingFiles =
    List(
       // these are the two classes clients will bootstrap against
       ("ServiceFacade.mustache",    destinationDir + java.io.File.separator + invokerPackage.get.replace(".", java.io.File.separator) + java.io.File.separator, additionalParams("facadeClassName") + ".java")
      ,("ServiceAssembler.mustache", destinationDir + java.io.File.separator + apiPackage.get.replace(".", java.io.File.separator) + java.io.File.separator, additionalParams("facadeClassName") + "Assembler.java")

      ,("common" + java.io.File.separator + "FallbackCallback.mustache",                destinationDir + java.io.File.separator + invokerPackage.get.replace(".", java.io.File.separator) + java.io.File.separator + "common", "FallbackCallback.java")
      ,("common" + java.io.File.separator + "InfusionsoftServiceClient.mustache",       destinationDir + java.io.File.separator + invokerPackage.get.replace(".", java.io.File.separator) + java.io.File.separator + "common", "InfusionsoftServiceClient.java")
      ,("common" + java.io.File.separator + "ServiceLocation.mustache",                 destinationDir + java.io.File.separator + invokerPackage.get.replace(".", java.io.File.separator) + java.io.File.separator + "common", "ServiceLocation.java")
      ,("common" + java.io.File.separator + "SimpleInfusionsoftServiceClient.mustache", destinationDir + java.io.File.separator + invokerPackage.get.replace(".", java.io.File.separator) + java.io.File.separator + "common", "SimpleInfusionsoftServiceClient.java")

      ,("common" + java.io.File.separator + "authentication" + java.io.File.separator + "BasicAuthCredentials.mustache",                        destinationDir + java.io.File.separator + invokerPackage.get.replace(".", java.io.File.separator) + java.io.File.separator + "common" + java.io.File.separator + "authentication", "BasicAuthCredentials.java")
      ,("common" + java.io.File.separator + "authentication" + java.io.File.separator + "FeignRequestAuthenticationStrategy.mustache",          destinationDir + java.io.File.separator + invokerPackage.get.replace(".", java.io.File.separator) + java.io.File.separator + "common" + java.io.File.separator + "authentication", "FeignRequestAuthenticationStrategy.java")
      ,("common" + java.io.File.separator + "authentication" + java.io.File.separator + "NoOpFeignRequestAuthenticationStrategy.mustache",      destinationDir + java.io.File.separator + invokerPackage.get.replace(".", java.io.File.separator) + java.io.File.separator + "common" + java.io.File.separator + "authentication", "NoOpFeignRequestAuthenticationStrategy.java")
      ,("common" + java.io.File.separator + "authentication" + java.io.File.separator + "BasicAuthFeignRequestAuthenticationStrategy.mustache", destinationDir + java.io.File.separator + invokerPackage.get.replace(".", java.io.File.separator) + java.io.File.separator + "common" + java.io.File.separator + "authentication", "BasicAuthFeignRequestAuthenticationStrategy.java")

      // now, get all the build artifact goodness
      ,("build.gradle.mustache",      destinationProjectDir, "build.gradle")
      ,("gradle.properties.mustache", destinationProjectDir, "gradle.properties")
      ,("gradlew",                    destinationProjectDir, "gradlew")
      ,("gradlew.bat",                destinationProjectDir, "gradlew.bat")
      ,("LICENSE",                    destinationProjectDir, "LICENSE")
      ,("README.md.mustache",         destinationProjectDir, "README.md")
      ,("settings.gradle.mustache",   destinationProjectDir, "settings.gradle")

      // get lazy.  copy the rest of the stuffs
      ,("gradle",                     destinationProjectDir + java.io.File.separator + "gradle", "" )
  )

}