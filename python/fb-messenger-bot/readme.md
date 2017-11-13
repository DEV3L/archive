# fb-messenger-bot

## Facebook Messenger Bot
This is a simple python template that uses Flask to build a webhook for Facebook's Messenger Bot API.

Read more in my [tutorial that uses this repository](https://blog.hartleybrody.com/fb-messenger-bot/)


## References

Setting up a new Flask application

- [Facebook - Send API Reference](https://developers.facebook.com/docs/messenger-platform/send-api-reference)


## Prerequisites

- [Python 3](https://www.python.org/downloads/)
- [Virtualenv](http://docs.python-guide.org/en/latest/dev/virtualenvs/)
- [Heroku toolbelt](https://devcenter.heroku.com/articles/heroku-command-line)


## Environment Variables

Facebook
[Facebook Messenger Bot Tutorial: Step #4](https://blog.hartleybrody.com/fb-messenger-bot/)
- 'PAGE_ACCESS_TOKEN'
- 'VERIFY_TOKEN'


## Running Locally (Linux/Mac)

```sh
$ git clone https://github.com/DEV3L/fb-messenger-bot.git
$ cd fb-messenger-bot

$ mkvirtualenv -p /usr/local/bin/python3 fb-messenger-bot
$ python setup.py develop

$ python app.py --host 0.0.0.0 --port 5000
# OR
$ heroku local
```

Your app should now be running on [localhost:5000](http://localhost:5000/).

- [localhost:5000](http://localhost:5000/)
