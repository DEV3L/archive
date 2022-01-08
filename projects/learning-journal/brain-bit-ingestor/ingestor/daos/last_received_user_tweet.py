from ingestor.daos.last_received_base import LastReceivedBase


class LastReceivedUserTweet(LastReceivedBase):
    def __init__(self, db, id_token, screen_name):
        super().__init__(db, id_token, f'last_received_tweet_{screen_name}')
