from multiprocessing import context
from django.shortcuts import render, redirect, HttpResponse

from .models import *

def index(request):
    context = {
        'books': Book.objects.all()
    }
    return render(request, 'index.html', context)

def addBook(request):
    Book.objects.create(title = request.POST['title'])
    return redirect('/')

def viewBooks(request, id):
    context = {
        'book': Book.objects.get(id=int(id)),
        'publishers': Publisher.objects.all()
    }
    return render(request, 'result.html', context)
def pubToBook(request, id):
    book1 = Book.objects.get(id == int(id))
    pub1 = Publisher.objects.get(id = request.POST['pubToBook'])
    book1.Publishers.add(pub1)
    return redirect('/books/' + str(id))