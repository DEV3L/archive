from django.contrib.auth.models import User
from django.db import models


class Board(models.Model):
    name = models.CharField(max_length=30, unique=True)
    description = models.CharField(max_length=100)
    # topics: list<Topic>


class Topic(models.Model):
    subject = models.CharField(max_length=255)
    last_updated = models.DateTimeField(auto_now_add=True)
    board = models.ForeignKey(Board, models.SET_NULL, related_name='topics')
    starter = models.ForeignKey(User, models.SET_NULL, related_name='topics')
    # posts: list<Post>


class Post(models.Model):
    message = models.TextField(max_length=4000)
    topic = models.ForeignKey(Topic, models.SET_NULL, related_name='posts')
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(null=True)
    created_by = models.ForeignKey(User, models.SET_NULL, related_name='posts')
    updated_by = models.ForeignKey(User, models.SET_NULL, null=True, related_name='+')  # ignore reverse relationship


"""
class User:
  username: str
  password: str
  email: EmailField
  is_superuser: bool
  * posts: list<Post>
  * topics: list<Topic>
"""
