# StripeRESTWebServiceDev3l
RESTful Web Service using RESTEasy - Stripe Credit Card Processing

## Notable Dependencies
	- Stripe API
		- com.stripe : v1.27.0
	- REST Client 
		- RESTEasy
		- org.jboss.resteasy : v3.0.11
	- Dependency Injection 
		- Google Guice
		- com.google.inject : guice : v3.0
	- Commons Lang
		- org.apache.commons : commons-lang3 : v3.3.2
	- Commons Configuration
		- commons-configuration : v1.10
	- Logging
		- Log4j
		- org.apache.logging.log4j : v2.1
	- Unit Testing
		- junit : v4.12


#Usage Instructions to Pull down and use template project from GitHub
1. From command line retrieve project from GitHub
	- git clone hhttps://github.com/DEV3L/StripeRESTWebServiceDev3l.git

2. Run maven package from inside the created directory
	- mvn clean package

3. StripeRESTWebServiceDev3l.war can be deployed to container of choice
	- http://services-dev3l.rhcloud.com/StripeRESTWebServiceDev3l
		- My personal OpenShift server I deploy projects too
	- CURL Commands to exercise CRUD operations
		- POST
			- curl -X POST http://services-dev3l.rhcloud.com/StripeRESTWebServiceDev3l/payment/charge -H "Content-Type: application/json" -d '{"number":"4242424242424242","expMonth":"01","expYear":"2018","cvc":"123","name":"Test Dev3l","currency":"usd","amount":"100"}'

4. Use Maven to resolve the dependencies and create eclipse dynamic web project and class/project files
	- mvn eclipse:eclipse -Dwtpversion=2.0

5. Import the project into Eclipse as an existing project