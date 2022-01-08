import time

from azure.eventhub import EventHubClient, Offset

from ingestor.utils.logging_service import LoggingService

logger = LoggingService('EventHubRetriever').logger

CONSUMER_GROUP = "$default"
PREFETCH = 1
EVENT_HUB_PARTITION = "1"


class EventHubRetriever:
    def __init__(self, client: EventHubClient, offset: Offset, *, partition: str = EVENT_HUB_PARTITION):
        self.client = client
        self.offset = offset
        self.partition = partition

    def fetch(self):
        start_time = time.time()

        receiver = self._add_receiver()
        for event_data in receiver.receive(timeout=10):
            sequence_number = event_data.sequence_number
            message = event_data.message

            logger.info(f"Received:{sequence_number}~~Message:{message}")

        end_time = time.time()

        run_time = end_time - start_time
        logger.info(f"Received Event Hub message in {run_time} seconds")

    def _add_receiver(self):
        receiver = self.client.add_receiver(CONSUMER_GROUP, self.partition, prefetch=PREFETCH, offset=self.offset)
        self.client.run()
        return receiver
