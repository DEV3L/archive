import time

from azure.eventhub import EventData

from ingestor.builders.build_sender_client import build_sender_client
from ingestor.utils.logging_service import LoggingService

logger = LoggingService('send_event_hub_message').logger

client = None
sender = None


def send_event_hub_message(message: str):
    global client
    global sender

    if not client or not sender:
        client, sender = build_sender_client()

    logger.info(f"Sending tweet message: {message}")

    start_time = time.time()
    sender.send(EventData(message))
    end_time = time.time()

    run_time = end_time - start_time
    logger.info("Runtime: {} seconds".format(run_time))


def stop_client():
    client.stop()
