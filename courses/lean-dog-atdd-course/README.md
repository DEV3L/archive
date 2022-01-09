# lean-dog-atdd-course
Acceptance Test Driven Development (ATDD) - On the Lean Dog Boat - Watir / Cucumber

# Lean Dog
http://www.leandog.com/

# ATDD Course
http://www.leandog.com/atdd/

# Presenters
* Patrick Kelly
* Doug Morgan
* Randy Eppinger

Course introduces the concepts of Acceptance Test Driven Development, also called Specification By Example. It teaches how ATDD changes the workflow of the entire development process. Through a series of targeted workshops, this course introduces Cucumber and Ruby scripting as well as the techniques necessary to write tests that are robust and easy to maintain. This course also includes workshops on test-data management, creating and validating XML files in the created test, and modifying scripts to handle the special needs of Ajax and JavaScript heavy applications.

The course was intended for programmers and non-programmers alike.

Previous Ruby/Watir experience was not a prerequisite.

WATIR - Web Application Test In Ruby

Gherkin predates Cucumber...

# Environment Setup / Requirements
* Ruby installed
* gem install watir-webdriver
* gem install testgen

# Course Overview
* 01_getting_started
  * basic WATIR
* 02_basic_form_interactions
  * basic navigation and form interaction
* 03_adopt_multiple_puppies
  * a bit more navigation and interaction
* 04_methods
  * refactor existing code base to use methods
* 05_shared_methods
  * refactor methods code base to use a module
* 06_this_is_cucumber
  * README.md!
  * a basic nonfunctional cucumber example
* 07_test_puppies_project
  * README.md!
  * Cucumber version of 03-05

# Terms
<dl>
  <dt>DRY</dt>
  <dd>Don't Repeat Yourself</dd>
  <dt>DAMP</dt>
  <dd>Descriptive And Meaningful Phrases</dd>
</dl>

# Course Notes
Communication tends to be the largest factor in the root cause of "bugs".
* Code tends to be over / under built
* Written requirements tend to not be expressive enough true intention
* Three Amigos == Good Start

### Conventions of cucumber...
	features directory contains features
		file extension .feature
	step_definitions contains step definitions
		files traditionally named with *_steps.rb
	support directory loaded by cucumber
		env.rb first one loaded

### SDLC Concepts
* Traditional
 * [Code]-[Days]-[Test]
* Agile
 * [Code][Test]
* ATDD
 * [Test][Code]
 * [Write Test][Code][Test]

Do we build a simple feature or write anticpiated frameworks?
* Simple with tons of tests => more reliable and robust

ATDD provides Regression and Confidence

Can use IRB and load and run webdriver

# Obstacles At Explorys
* No Boundries => THIS is our boundry
* No traditional QA Staff
* Beginning story acceptance criteria
