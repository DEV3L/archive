from ingestor.utils.env import env
from ingestor.utils.logging_service import LoggingService
from ingestor.utils.read_json import read_json

logger = LoggingService('read_tweet_json').logger

PROFILE = env('PROFILE_NAME')

data_path = './data'
tweet_json_file_name = 'tweet.json'


def read_tweet_json(profile_to_read: str = PROFILE) -> list:
    tweet_json_profile_data_path = f'{data_path}/{profile_to_read}/{tweet_json_file_name}'

    logger.info(f"Reading tweet file: {tweet_json_profile_data_path}")

    return read_json(tweet_json_profile_data_path)
