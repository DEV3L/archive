import os

import boto
from boto.s3 import connection as boto_s3_connection

os_env_aws_access_key_id = 'AWS_ACCESS_KEY_ID'
os_env_aws_secret_access_key = 'AWS_SECRET_ACCESS_KEY'


class BotoWrapper():
    s3_connection_host = 'objects.dreamhost.com'

    def __init__(self):
        if not os_env_aws_access_key_id in os.environ:
            raise_missing_environment_variable_error('AWS Access Key ID', os_env_aws_access_key_id)
        if not os_env_aws_secret_access_key in os.environ:
            raise_missing_environment_variable_error('AWS Secret Access Key', os_env_aws_secret_access_key)

        self.aws_access_key_id = os.environ[os_env_aws_access_key_id]
        self.aws_secret_access_key = os.environ[os_env_aws_secret_access_key]

        self._connection = None

    @property
    def connection(self):
        if self._connection:
            return self._connection

        self._connection = boto.connect_s3(aws_access_key_id=self.aws_access_key_id,
                                           aws_secret_access_key=self.aws_secret_access_key,
                                           host=self.s3_connection_host,
                                           calling_format=boto_s3_connection.OrdinaryCallingFormat())
        return self._connection


def raise_missing_environment_variable_error(name, key):
    message = f'Missing environment variable for {name} - {key}'
    raise RuntimeError(message)
