from ingestor.utils.logging_service import LoggingService
from tests.integration import build_firebase_connection_for_tests

logger = LoggingService('Write Firebase').logger


def test_write():
    db, id_token = build_firebase_connection_for_tests()

    # create
    archer = {"name": "Sterling Archer", "agency": "Figgis Agency"}
    db.child("agents").push(archer, id_token)

    # set
    lana = {"name": "Lana Kane", "agency": "Figgis Agency"}
    db.child("agents").child("Lana").set(lana, id_token)

    # read all
    all_agents = db.child("agents").get(id_token).val()
    assert len(all_agents) >= 2

    # read one
    lana_data = db.child("agents").child("Lana").get(id_token).val()
    assert "Lana Kane" == lana_data['name']

    # update
    db.child("agents").child("Lana").update({"name": "Lana Anthony Kane"}, id_token)
    new_lana_data = db.child("agents").child("Lana").get(id_token).val()
    assert 'Lana Anthony Kane' == new_lana_data['name']

    # delete item
    db.child("agents").child("Lana").remove(id_token)

    # delete collection
    db.child("agents").remove(id_token)

    all_agents = db.child("agents").get(id_token).val()
    assert not all_agents
