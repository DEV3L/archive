import os
from unittest.mock import patch

import pytest

from wisdom_chatbot.wrappers.boto.boto_wrapper import BotoWrapper, os_env_aws_access_key_id, \
    os_env_aws_secret_access_key

expected_aws_access_key_id = 'harambe'
expected_aws_secret_access_key = 'save_me_tom_cruise'


@pytest.fixture()
def boto_wrapper():
    os.environ[os_env_aws_access_key_id] = expected_aws_access_key_id
    os.environ[os_env_aws_secret_access_key] = expected_aws_secret_access_key

    boto_wrapper = BotoWrapper()

    assert expected_aws_access_key_id == boto_wrapper.aws_access_key_id
    assert expected_aws_secret_access_key == boto_wrapper.aws_secret_access_key

    return boto_wrapper


def delete_aws_environment_variables():
    if os_env_aws_access_key_id in os.environ:
        del os.environ[os_env_aws_access_key_id]
    if os_env_aws_secret_access_key in os.environ:
        del os.environ[os_env_aws_secret_access_key]


def test_boto_wrapper_reads_aws_credentials_from_env_properties_error_missing_aws_access_key_id():
    delete_aws_environment_variables()
    expected_error = 'Missing environment variable for AWS Access Key ID - AWS_ACCESS_KEY_ID'

    with pytest.raises(RuntimeError) as runtime_error:
        BotoWrapper()

    assert expected_error == str(runtime_error.value)


def test_boto_wrapper_reads_aws_credentials_from_env_properties_error_missing_aws_secret_access_key():
    delete_aws_environment_variables()
    os.environ[os_env_aws_access_key_id] = expected_aws_access_key_id
    expected_error = 'Missing environment variable for AWS Secret Access Key - AWS_SECRET_ACCESS_KEY'

    with pytest.raises(RuntimeError) as runtime_error:
        BotoWrapper()

    assert expected_error == str(runtime_error.value)


@patch('wisdom_chatbot.wrappers.boto.boto_wrapper.boto_s3_connection')
@patch('wisdom_chatbot.wrappers.boto.boto_wrapper.boto')
def test_boto_wrapper_connect_to_s3(mock_boto, mock_connection, boto_wrapper):
    connection_object = 'a_s3_connection_object'
    expected_boto_connect_s3_call_count_due_to_caching = 1
    mock_boto.connect_s3.return_value = connection_object

    assert boto_wrapper.connection
    assert connection_object == boto_wrapper.connection
    assert expected_boto_connect_s3_call_count_due_to_caching == mock_boto.connect_s3.call_count

    mock_boto.connect_s3.assert_called_with(aws_access_key_id=expected_aws_access_key_id,
                                            aws_secret_access_key=expected_aws_secret_access_key,
                                            host='objects.dreamhost.com',
                                            calling_format=mock_connection.OrdinaryCallingFormat.return_value)
