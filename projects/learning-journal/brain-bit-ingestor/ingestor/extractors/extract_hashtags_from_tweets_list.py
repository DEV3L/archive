from collections import defaultdict

from ingestor.utils.env import env
from ingestor.utils.logging_service import LoggingService

logger = LoggingService('extract_hashtags_from_tweets_list').logger

profile = env('PROFILE_NAME')


def extract_hashtags(tweets: list) -> dict:
    hashtags_found = defaultdict(int)

    for tweet in tweets:
        tweet_hashtags = tweet['entities']['hashtags']
        [_add_to_aggregate(hashtags_found, tweet_hashtag['text'].lower()) for tweet_hashtag in tweet_hashtags]

    return hashtags_found


def _add_to_aggregate(aggregate_dict: dict, key: str):
    aggregate_dict[key] = aggregate_dict[key] + 1
