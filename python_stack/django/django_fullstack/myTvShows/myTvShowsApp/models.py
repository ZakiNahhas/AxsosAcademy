from platform import release
from django.db import models

class Show(models.Model):
    title = models.CharField(max_length=75)
    network = models.CharField(max_length=4)
    release_date = models.DateField()
    description = models.TextField(default = "This is a show description ma nigga")
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)