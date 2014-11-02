swagger-codegen-templates
=========================

This depends on a [small change to swagger codegen](https://github.com/swagger-api/swagger-codegen/pull/323), 
though the templates could be rewritten to not need it.

Look in [java-gradle/config/IsftServiceClient.scala] for the configuration overrides.  In that, notice a few extra overrides not
identified in the public docs: `apiTemplateFiles` and `additionalParams`.

Of course, the list of supporting files is dramatically different.  Many of the gradle conventions are specific to my org,
but vanilla gradle build files are easy enough to substitute.

If you find this helpful or interesting, let me know: @DietSodaSoft
