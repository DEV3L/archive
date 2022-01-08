from ingestor.readers.read_tweet_json import read_tweet_json
from ingestor.senders.send_event_hub_message import send_event_hub_message, stop_client
from ingestor.utils.env import env
from ingestor.utils.logging_service import LoggingService

logger = LoggingService('Send tweet.json').logger

PROFILE = env('PROFILE_NAME')

message_type = 'tweet'
data_delimiter = '|~|'


def build_message(profile: str, message_type: str,
                  event_id: str, message: str,
                  *, delimiter: str = data_delimiter):
    structured_message = \
        f'profile:{profile}{delimiter}' \
        f'type:{message_type}{delimiter}' \
        f'id:{event_id}{delimiter}' \
        f'message:{message}'

    return structured_message


if __name__ == "__main__":
    tweets = read_tweet_json()

    for tweet in tweets:
        tweet_json = js
        on.dumps(tweet)
        tweet_id = tweet['id']

        message = build_message(PROFILE, message_type, tweet_id, tweet_json)
        send_event_hub_message(message)

    stop_client()
