# eve-building-restful-mongodb-backed-apis-course
Repository for Talk Python Training Course - Eve: Building RESTful APIs with MongoDB and Flask


# Prerequisites
* Python ^3.6
* Mongodb
* Pyenv / Virtualenv (strongly suggested)
* Postman (strongly suggested)


# Run
```bash
git clone git@github.com:DEV3L/eve-building-restful-mongodb-backed-apis-course.git
mkvirtualenv -p /usr/local/bin/python3 eve-building-restful-mongodb-backed-apis-course
python setup.py develop
python app.py
```


# References
* Talk Python Course: [Eve: Building RESTful APIs with MongoDB and Flask](https://training.talkpython.fm/courses/details/eve-building-restful-mongodb-backed-apis-course)
* [Eve. The Simple Way to REST](http://python-eve.org/)
  * Eve is built on top of Flask! Anything you can do with Flask, you can do with Eve!


# Course Notes

### Rest Principles
1. **Resource**
    * The source of specific information
2. **Global Permanent Identifier**
    * Every resource is uniquely identified
3. **Standard Interface**
    * Used to exchange representations of resources
4. **Set of Constraints**
    * Separation of concerns, stateless, cacheability, layered, system, uniform interface, hateoas

### Flask - Integrated unit testing
```python
import flask

app = flask.Flask(__name__)


with app.test_request_context('/?name=Peter'):
    assert flask.request.path == '/'
    assert flask.request.args['name'] == 'Peter'

```

### Flask Overview - Hello World
```bash
FLASK_APP=hello.py FLASK_DEBUG=1 flask run
```
