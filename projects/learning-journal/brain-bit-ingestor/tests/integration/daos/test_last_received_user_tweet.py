from ingestor.daos.last_received_user_tweet import LastReceivedUserTweet

from tests.integration import build_firebase_connection_for_tests


def test_last_received_event_offset():
    db, id_token = build_firebase_connection_for_tests()

    expected_sequence = "1"
    expected_item_name = 'last_received_tweet_screen_name'

    last_received_user_tweet = LastReceivedUserTweet(db, id_token, 'screen_name')
    last_received_user_tweet.write_offset(expected_sequence)
    sequence = last_received_user_tweet.get_offset()

    assert expected_sequence == sequence
    assert last_received_user_tweet.item_name == expected_item_name
