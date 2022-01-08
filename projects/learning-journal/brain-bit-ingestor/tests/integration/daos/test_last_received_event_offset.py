from ingestor.daos.last_received_event_offset import LastReceivedEventOffset

from tests.integration import build_firebase_connection_for_tests


def test_last_received_event_offset():
    db, id_token = build_firebase_connection_for_tests()

    expected_sequence = "1"
    expected_item_name = 'test_event_sequence'

    last_received_event_sequence = LastReceivedEventOffset(db, id_token, key=expected_item_name)
    last_received_event_sequence.write_offset(expected_sequence)
    sequence = last_received_event_sequence.get_offset()

    assert expected_sequence == sequence
    assert last_received_event_sequence.item_name == expected_item_name
