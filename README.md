Travel Innovation Sandbox Java Client Tests
===========================================
This project tests the Swagger generated Java client.

* Set the environment variable `apikey` to be your sandbox.amadeus.com API key
* Download the Java client from http://api.sandbox.amadeus.com/swagger-codegen/java and unzip to this folder.
* Run `mvn test` to run the tests against the client

To edit in eclipse, run maven install to build the project, import this as a maven project in Eclipse, then right-click target/generated-sources/swagger/src/main/java in the Eclipse navigator and select Build Path -> Use as Source Folder

Enjoy! Tadhg