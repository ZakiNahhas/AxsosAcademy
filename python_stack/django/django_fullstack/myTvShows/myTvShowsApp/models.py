from django.db import models
from datetime import date
from datetime import datetime

class ShowManager(models.Manager):
    def basic_validator(self, postData):
        errors = {}
        if len(postData['title']) < 5:
            errors["title"] = "Show name should be unique and at least 5 characters"
        if len(postData['description']) < 10 and len(postData['description']) != 0:
            errors["desc"] = "Show description should be at least 10 characters or none at all"
        if len(postData['network']) < 3:
            errors["network"] = "Network name should be at least 3 characters"
        if postData['release_date'] > str(datetime.now().strftime('%Y-%m-%d')) and postData['release_date'] == 0:
            errors['release_date'] = "release date can only be in the past"
        return errors
    
class Show(models.Model):
    title = models.CharField(max_length=75, unique=True, blank = False)
    network = models.CharField(max_length=4, blank=False)
    release_date = models.DateField(blank=True, null=True)
    description = models.TextField(default = "This is a show description ma nigga")
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    objects = ShowManager()
