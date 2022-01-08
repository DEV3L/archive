import operator

from ingestor.extractors.extract_hashtags_from_tweets_list import extract_hashtags
from ingestor.readers.read_tweet_json import read_tweet_json
from ingestor.utils.logging_service import LoggingService

logger = LoggingService('Read tweet.json').logger


def _add_to_aggregate(aggregate_dict: dict, key: str):
    aggregate_dict[key] = aggregate_dict[key] + 1


if __name__ == "__main__":
    tweets = read_tweet_json()
    print(tweets)

    hashtags = extract_hashtags(tweets)
    hashtags_sorted = sorted(hashtags.items(), key=operator.itemgetter(1), reverse=True)

    print(hashtags_sorted)
