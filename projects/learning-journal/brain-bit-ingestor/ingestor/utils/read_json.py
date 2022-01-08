import json


def read_json(json_file_path: str) -> list:
    with open(json_file_path) as json_file:
        return json.load(json_file)
