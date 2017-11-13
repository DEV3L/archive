# StripeDev3l
Java Stripe Credit Card Processing Example

### Project setup
* git clone https://github.com/DEV3L/StripeDev3l.git
* cd StripeDev3l/
* mvn clean package
* Eclipse Project Setup
  * mvn eclipse:eclipse
  * In Eclipse, import directory as existing project

### Project Highlights:
* Uses Stripe v_1.27.1
  * Test API Key used by default
  * Update to personal key in file:
    * src/main/resources/stripe_configuration.properties
    * src/test/resources/stripe_configuration.properties
* Simple API:
  * StripeAgent.charge(StripeBean) -> Execute a "charge" action
* JUnit Test Coverage (Example Usage)

#### REQUIRES
* Maven