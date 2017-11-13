import random

from app.utils.faker_wrapper import fake_name, fake_job


class Employee():
    def __init__(self, *, name=None, job=None, wait_time=None):
        self.name = name or fake_name()
        self.job = job or fake_job()
        self.wait_time = wait_time or random.randint(1, 10)
