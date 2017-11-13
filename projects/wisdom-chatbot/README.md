[![Build Status](https://travis-ci.org/DEV3L/wisdom-chatbot.svg?branch=master)](https://travis-ci.org/DEV3L/wisdom-chatbot)
[![Coverage Status](https://coveralls.io/repos/github/DEV3L/wisdom-chatbot/badge.svg)](https://coveralls.io/github/DEV3L/wisdom-chatbot)
[![Code Climate](https://codeclimate.com/github/DEV3L/wisdom-chatbot/badges/gpa.svg)](https://codeclimate.com/github/DEV3L/wisdom-chatbot)

# widsom-chatbot
A bot that broadcasts a prophetic message to a HipChat room once a day.

---

I envision a bot in which a prophetic message can be broadcasted daily.

To start, I am going to do a code smell a day posted to a HipChat room.

In order to do this, I first need to be able to persistant storage for my bot to access.
I do not want the same random code smell to be posted, until all code smells have been posted.


## References
- [Using AWS S3 to Store Static Assets and File Uploads](https://devcenter.heroku.com/articles/s3)
- [Deploying a Flask Application to Heroku](http://docs.ceph.com/docs/master/radosgw/s3/python)
- [Adding an existing project to GitHub using the command line](https://help.github.com/articles/adding-an-existing-project-to-github-using-the-command-line)

## Prerequisites
- assume aws account available
- assume heroku account available
- assume travis ci account available
- assume coveralls account available
- assume codeclimate account available
- assume python 3.6.1 runtime

## Environment Variables
TBD

## Running Locally
TBD

## Contributing
1. Fork it!
2. Create your feature branch: `git checkout -b my-new-feature`
3. Commit your changes: `git commit -am 'Add some feature'`
4. Push to the branch: `git push origin my-new-feature`
5. Submit a pull request :D


## License
BEER-WARE

## Project Discovery Steps
These are my own ramblings in which I went through during the inception of this project...

### Create aws security credentials
- ignored Identity Access Management
  - May regret this decision it said!
- log into aws, from the username drop down selected 'My Security Credentials'
- Access Keys (Access Key ID and Secret Access Key) => Create New Access Key
- These will be needed later

### Setup s3 storage on aws
- create Storage S3 bucket : wisdom-chatbot

### Setup GitHub project
- initialize with this as the README.md
- add some file structure
- realized I want CI integration of tests

### Setup Travis CI on Project
- created travis.yml
- updated project to have requirements.txt (not sure if travis plays nice with setup.py)
- enabled project through accounts

### Setup Coveralls on Project
- enabled project add repos drawer menu

### Add Code Climate Badge to README
- enabled project on codeclimate.com

### Add tox
- add tox.ini

```
(wisdom-chatbot) ➜  wisdom-chatbot git:(master) ✗ pip install tox
(wisdom-chatbot) ➜  wisdom-chatbot git:(master) ✗ tox
```

## Ramblings
#### Struggled getting Python 3.6.1 virtualenv setup on my Mac

```
➜  ~ pip install --upgrade pip
➜  ~ pip install --upgrade virtualenvwrapper
➜  ~ mkvirtualenv -p /usr/local/bin/python3 wisdom-chatbot
```

#### Why boto3?
- [what-is-the-difference-between-the-aws-boto-and-boto3](https://stackoverflow.com/questions/32322503/what-is-the-difference-between-the-aws-boto-and-boto3)
