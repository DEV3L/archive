from azure.eventhub import EventData

from ingestor.builders.build_sender_client import build_sender_client

message = "Hello, World!"


def test_send():
    expected_outcome = 'Ok'

    client, sender = build_sender_client()
    send_result = sender.send(EventData(message))
    client.stop()

    assert expected_outcome == send_result.name
