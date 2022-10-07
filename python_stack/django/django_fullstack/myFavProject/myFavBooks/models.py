from email.policy import default
from email.utils import localtime
from django.db import models
import re
import datetime

class UserManager(models.Manager):
    def basic_validator(self, postData):
        errors = {}
        if len(postData['firstname']) < 2:
            errors["firstname"] = "Show name should be at least 5 characters"
        if len(postData['lastname']) < 2:
            errors["lastname"] = "Last name should be at least 5 characters"
        if len(postData['password']) < 8:
            errors["password"] = "Password should be at least 8 characters"
        if postData["password_confirm"] != postData["password"]:
            errors["password_confirm"] = "Please make sure passwords match."
        EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')
        if not EMAIL_REGEX.match(postData['email']):          
            errors['email'] = "Invalid email address!"
        if postData['birth_day'] > str(datetime.date(2009, 1, 1)):
            errors["birth_day"] = "You must be +13"
        return errors
    
class User(models.Model):
    firstname = models.CharField(max_length=75, blank = False)
    lastname = models.CharField(max_length=75, blank = False, null = True)
    email = models.CharField(max_length=255, blank = False)
    password = models.CharField(max_length=75, blank = False)
    password_confirm = models.CharField(max_length=75, blank = False)
    birth_day = models.DateField(default = localtime)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    objects = UserManager()

class Book(models.Model):
    book_title = models.CharField(max_length = 255)
    description = models.TextField()
    uploaded_by = models.ForeignKey(User, related_name = "books", on_delete = models.CASCADE, null = True)
    liked_by = models.ManyToManyField(User, related_name = "liked_books")
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    