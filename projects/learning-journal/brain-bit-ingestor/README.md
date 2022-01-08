# brain-bit-ingestor
Event ingestion for Brain Bit using Azure Event Hub.

## Prerequisites

- Python 3.6.x
- _(Optional)_ [Virtual Environment Wrapper](https://python-guide-cn.readthedocs.io/en/latest/dev/virtualenvs.html)
- [Azure Event Hubs](https://docs.microsoft.com/en-us/azure/event-hubs/event-hubs-create) Setup


## Setup

- `mkvirtualenv -p /usr/local/bin/python3 brain-bit-ingestor`
- `workon brain-bit-ingestor`
- `python setup.py develop`
- `pytest`
- Set Environment Variables in `.env`


## Azure Event Hub

#### Send Message
`python spike-send.py`

#### Receive Messages
`python spike-receive.py`

## Example Output
```
➜ python ./spikes/spike-send.py
2019-08-25 15:56:43,183 - Send - INFO - Sending message: Hello, World!
2019-08-25 15:56:43,729 - Send - INFO - Runtime: 0.0870518684387207 seconds
➜ python ./spikes/spike-receive.py
Unable to set external certificates.
2019-08-25 15:56:51,842 - Receive - INFO - Received:<azure.eventhub.common.Offset object at 0x1086d8210>|0-Message:Hello, World!
2019-08-25 15:56:52,803 - Receive - INFO - Received 1 messages in 0.056581974029541016 seconds
```

## Contributing

1. Fork it!
2. Create your feature branch: `git checkout -b my-work`
3. Commit your changes: `git commit -am 'Add some work'`
4. Push to the branch: `git push origin my-work`
5. Submit a pull request :D
