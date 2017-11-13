import json
import os

import requests

ACCESS_TOKEN = os.environ.get("PAGE_ACCESS_TOKEN")

# justin.beall.90
_recipient_id = '931412460297745'


def send_message(recipient_id, message_text, *, access_token=ACCESS_TOKEN):
    print("sending message to {recipient}: {text}".format(recipient=recipient_id, text=message_text))

    params = {
        "access_token": access_token
    }
    headers = {
        "Content-Type": "application/json"
    }
    data = json.dumps({
        "recipient": {
            "id": recipient_id
        },
        "message": {
            "text": message_text
        }
    })
    request = requests.post("https://graph.facebook.com/v2.6/me/messages", params=params, headers=headers, data=data)
    if request.status_code != 200:
        print(request.status_code)
        print(request.text)


if __name__ == '__main__':
    send_message(_recipient_id, 'Hello there Aiden, I figured out how to send messages!')
