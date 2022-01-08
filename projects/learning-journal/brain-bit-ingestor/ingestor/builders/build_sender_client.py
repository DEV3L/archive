from azure.eventhub import EventHubClient

from ingestor.utils.env import env
from ingestor.utils.logging_service import LoggingService

logger = LoggingService('build_sender_client').logger

CONNECTION_STRING = env('EVENT_HUB_CONNECTION_STRING')
EVENT_HUB_TOPIC = env('EVENT_HUB_TOPIC_HELLO_WORLD_NAME')
EVENT_HUB_PARTITION = env('EVENT_HUB_TOPIC_HELLO_WORLD_PARTITION')


def build_sender_client(*, topic: str = EVENT_HUB_TOPIC, partition: str = EVENT_HUB_PARTITION) -> tuple:
    if not CONNECTION_STRING:
        raise ValueError("No EventHubs URL supplied.")

    client = EventHubClient.from_connection_string(CONNECTION_STRING, topic)
    sender = client.add_sender(partition)
    client.run()

    return client, sender
