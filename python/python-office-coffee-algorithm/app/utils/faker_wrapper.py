from faker import Factory

_faker = None


def get_faker_instance():
    global _faker

    if not _faker:
        return _faker

    _faker = Factory.create()
    return _faker


def fake_name():
    return get_faker_instance().name()


def fake_job():
    return get_faker_instance().job()
