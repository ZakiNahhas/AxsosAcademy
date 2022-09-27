from multiprocessing import context
from django.shortcuts import render, redirect, HttpResponse

from .models import *

def index(request):
    context = {
        'books': Book.objects.all()
    }
    return render(request, 'index.html', context)

def add_book(request):
    Book.objects.create(title = request.POST['title'], description = request.POST['description'])
    return redirect('/')

def view_books(request, id):
    context = {
        'book': Book.objects.get(id=int(id)),
        'authors': Author.objects.all()
    }
    return render(request, 'result.html', context)


def auth_to_book(request, id):
    book1 = Book.objects.get(id = int(id))
    auth1 = Author.objects.get(id = request.POST['authToBook'])
    book1.authors.add(auth1)
    return redirect(f'/books/{id}' )


def view_authors(request, id):
    context = {
        'authors': Author.objects.get(id = int(id)),
        'books': Book.objects.all(),
        'auth': Author.objects.all(),
    }
    return render(request, "authorsResult.html", context)
def add_author(request):
    Author.objects.create(firstname = request.POST['firstname'], lastname = request.POST['lastname'], notes = request.POST['notes'])
    return redirect('/authors')

def authors(request):
    context = {
        'authors': Author.objects.all()
    }
    return render(request, 'authors.html', context)
def book_to_auth(request, id):
    auth1 = Author.objects.get(id = int(id))
    book1 = Book.objects.get(id = request.POST['bookToAuth'])
    auth1.books.add(book1)
    return redirect(f'/authors/{id}')