# HelwohoData
HelwohoData - Using jOOQ

Project is the database object layer used in the Helwoho project

## Dependancies
* git
* maven
 * comments in pom.xml explain various steps
* mySQL installed and running locally
 * authentication
  * user: root
  * password:
  * values can be changed to appropriate local configuration in pom.xml

## Required Project(s)
* CryptoDev3l

## Project Highlights
* jOOQ 3.5
* Maven plugin utilization for project setup
 * Executes sql scripts to create schema and table if not exists
 * Generates jOOQ source files
 * Compiles after these two steps
* JUnit Test Coverage (Example Usage)
 * AuthorManagerIT
* Maven Dependencies Used
 * junit
 * log4j
 * jooq
 * javax validation
 * mysql driver

## Eclipse Project setup
* Use git clone to pull project into workspace directory
 * git clone https://github.com/DEV3L/HelwohoData.git
* Use maven to resolve Eclipse dependencies
 * mvn eclipse:eclipse
  * generates db and jooq code
* Import 'HelwohoData' as existing project into Eclipse 
* Use maven to run integration tests and install
 * mvn clean install
