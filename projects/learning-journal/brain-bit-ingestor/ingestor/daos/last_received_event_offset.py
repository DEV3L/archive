from ingestor.daos.last_received_base import LastReceivedBase


class LastReceivedEventOffset(LastReceivedBase):
    def __init__(self, db, id_token, *, key: str = 'last_received_event_offset'):
        super().__init__(db, id_token, key)
