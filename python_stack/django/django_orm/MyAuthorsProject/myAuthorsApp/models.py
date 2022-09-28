from email.policy import default
from django.db import models

class BookManager(models.Manager):
    def basic_validator(self, postData):
        errors = {}
        if len(postData['title']) < 5:
            errors["title"] = "Book name should be at least 5 characters"
        if len(postData['description']) < 10:
            errors["description"] = "Book description should be at least 10 characters"
        return errors

class Book(models.Model):
	title = models.CharField(max_length=255)
	description = models.TextField(default = "This is a book description")
	created_at = models.DateTimeField(auto_now_add=True)
	updated_at = models.DateTimeField(auto_now=True)
	objects = BookManager()

class Author(models.Model):
	firstname = models.CharField(max_length=255)
	lastname = models.CharField(max_length=255)
	notes = models.TextField(null = True)
	books = models.ManyToManyField(Book, related_name="authors")
	created_at = models.DateTimeField(auto_now_add=True)
	updated_at = models.DateTimeField(auto_now=True)