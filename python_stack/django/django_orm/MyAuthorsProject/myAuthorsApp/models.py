from email.policy import default
from django.db import models

class Book(models.Model):
	title = models.CharField(max_length=255)
	description = models.TextField(default = "This is a book description")
	created_at = models.DateTimeField(auto_now_add=True)
	updated_at = models.DateTimeField(auto_now=True)

class Author(models.Model):
	firstname = models.CharField(max_length=255)
	lastname = models.CharField(max_length=255)
	notes = models.TextField(null = True)
	books = models.ManyToManyField(Book, related_name="authors")
	created_at = models.DateTimeField(auto_now_add=True)
	updated_at = models.DateTimeField(auto_now=True)