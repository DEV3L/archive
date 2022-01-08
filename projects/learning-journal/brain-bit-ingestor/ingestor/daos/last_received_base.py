class LastReceivedBase:
    def __init__(self, db, id_token, item_name: str):
        self.db = db
        self.idToken = id_token
        self.collection = 'received_events'
        self.item_name = item_name

    def write_offset(self, sequence: str):
        sequence_item = {'sequence': sequence}
        self.db.child(self.collection).child(self.item_name).set(sequence_item, self.idToken)

    def get_offset(self):
        sequence = self.db.child(self.collection).child(self.item_name).get(self.idToken).val()
        return sequence['sequence'] if sequence and 'sequence' in sequence else 0
