import time

from azure.eventhub import EventHubClient, Offset

from ingestor.builders.build_firebase import get_firebase_auth_and_db
from ingestor.daos.last_received_event_offset import LastReceivedEventOffset
from ingestor.retrievers.event_hub_retriever import EventHubRetriever
from ingestor.utils.env import env
from ingestor.utils.logging_service import LoggingService

logger = LoggingService('Receive').logger

CONNECTION_STRING = env('EVENT_HUB_CONNECTION_STRING')
EVENT_HUB_TOPIC = env('EVENT_HUB_TOPIC_HELLO_WORLD_NAME')
EVENT_HUB_PARTITION = env('EVENT_HUB_TOPIC_HELLO_WORLD_PARTITION')

CONSUMER_GROUP = "$default"
PREFETCH = 1
OFFSET = Offset('1', inclusive=True)

USER = env('FIREBASE_AUTH_USER')
PASSWORD = env('FIREBASE_AUTH_PASSWORD')


def receive_one():
    auth, db = get_firebase_auth_and_db()

    user = auth.sign_in_with_email_and_password(USER, PASSWORD)
    id_token = user['idToken']

    last_received_event_offset = LastReceivedEventOffset(db, id_token)
    offset_value = "72500"
    offset = Offset(offset_value, inclusive=True)

    client = build_client()

    event_hub_retriever = EventHubRetriever(client, offset)
    event_hub_retriever.fetch()

    client.stop()


def receive_all_using_last_received_event_sequence():
    auth, db = get_firebase_auth_and_db()

    user = auth.sign_in_with_email_and_password(USER, PASSWORD)
    id_token = user['idToken']

    total = 0
    has_data = True

    client = build_client()
    last_received_event_sequence = LastReceivedEventOffset(db, id_token)
    last_offset = last_received_event_sequence.get_offset()
    receiver = add_receiver(client, Offset(last_offset, inclusive=True))

    start_time = time.time()

    while has_data:
        has_data = False
        for event_data in receiver.receive(timeout=10):
            has_data = True

            sequence_number = event_data.sequence_number
            offset = event_data.offset
            message = event_data.message
            last_received_event_sequence.write_offset(offset.value)
            logger.info(f"Offset:{offset.value}||Sequence:{sequence_number}==>Message:{message}")
            total += 1

    end_time = time.time()

    run_time = end_time - start_time
    logger.info(f"Received {total} messages in {run_time} seconds")

    client.stop()


def build_receiver_client(*, offset=OFFSET):
    client = EventHubClient.from_connection_string(CONNECTION_STRING, EVENT_HUB_TOPIC)
    receiver = client.add_receiver(CONSUMER_GROUP, EVENT_HUB_PARTITION, prefetch=PREFETCH, offset=offset)
    client.run()
    return client, receiver


def build_client() -> EventHubClient:
    client = EventHubClient.from_connection_string(CONNECTION_STRING, EVENT_HUB_TOPIC)
    return client


def add_receiver(client: EventHubClient, offset: Offset):
    receiver = client.add_receiver(CONSUMER_GROUP, EVENT_HUB_PARTITION, prefetch=PREFETCH, offset=offset)
    client.run()
    return receiver


if __name__ == "__main__":
    if not CONNECTION_STRING:
        raise ValueError("No EventHubs URL supplied.")

    receive_all_using_last_received_event_sequence()
    # receive_all_using_last_received_event_sequence()
