from tweepy import API

from app.harvesters.twitter.tweets import Tweets


class TwitterHarvester():
    def __init__(self, api: API, screen_name: str, last_tweet_id: str):
        self.api = api
        self.screen_name = screen_name
        self.last_tweet_id = last_tweet_id

    def fetch(self):
        # retrieved_tweets = []
        # retrieved_tweets.extend(self._fetch('tweet'))
        # retrieved_tweets.extend(self._fetch('favorite'))
        tweet = self._fetch('tweet')
        return tweet

    def _fetch(self, tweet_type):
        tweets = Tweets(self.api, self.screen_name, self.last_tweet_id, tweet_type=tweet_type)
        return tweets.get()
