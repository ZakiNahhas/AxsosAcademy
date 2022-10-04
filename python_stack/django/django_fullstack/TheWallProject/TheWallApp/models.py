from django.db import models
from myLoginApp.models import *
# Create your models here.
class Message(models.Model):
    message_content = models.TextField()
    user = models.ForeignKey(User, related_name = "messages", on_delete = models.CASCADE)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    
class Comment(models.Model):
    comment_content = models.TextField()
    user = models.ForeignKey(User, related_name = "comments", on_delete = models.CASCADE)
    messages = models.ForeignKey(Message, related_name = "comments", on_delete = models.CASCADE, null = True)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)