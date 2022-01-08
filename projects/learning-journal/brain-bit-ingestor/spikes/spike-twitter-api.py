from app.harvesters.twitter.api import get_api
from app.harvesters.twitter_harvester import TwitterHarvester

from ingestor.utils.env import env

env("")

twitter_harvester = TwitterHarvester(get_api(), 'dev3l_', '')
twitter_harvester.fetch()
