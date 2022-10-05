from django.shortcuts import render, redirect
from django.contrib import messages
from .models import *

from django.shortcuts import render, redirect, HttpResponse
from django.contrib import messages
from .models import *
import bcrypt

def index(request):
    return render(request, "form.html")

def register(request):
    errors = User.objects.basic_validator(request.POST)
    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)
        return redirect('/')
    else:
        
        password = request.POST['password']
        pw_hash = bcrypt.hashpw(request.POST['password'].encode(), bcrypt.gensalt()).decode()  
        user = User.objects.create(
        firstname=request.POST["firstname"],
        lastname=request.POST["lastname"],
        email=request.POST["email"],
        password=pw_hash
    )
        user=User.objects.last()
        request.session['firstname'] = user.firstname
        request.session["user_id"] = user.id
    return redirect('/books')

def login(request):
    existing_user = User.objects.filter(email=request.POST['email'])

    if len(existing_user) == 0:
        messages.error(request, "Please enter valid credentials.")

        return redirect('/')

    user = existing_user[0]

    if not bcrypt.checkpw(request.POST['password'].encode(), user.password.encode()):
        messages.error(request, "Please enter valid credentials.")

        return redirect('/')

    request.session['firstname'] = user.firstname
    request.session["user_id"] = user.id
    return redirect('/books')

def logout(request):
    request.session.clear()
    return redirect('/')

def books(request):
    context = {
        'users': User.objects.all(),
        'books': Book.objects.all(),
    }

    return render(request,'books.html',context)
    
def add_book(request):
    Book.objects.create(
        book_title = request.POST['book_title'],
        description = request.POST['description'],
        # user=User.objects.get(id=request.session['user_id'])
    )
    return redirect('/books')
# def logout(request):
#     del request.session['user_id']
#     del request.session['firstname']
#     request.session.flush()
#     return redirect('/')

def edit(request):
    book = Book.objects.get(id = request.session["user_id"])
    new_book = Book.objects.create(
        book_title = request.POST['book_title']
        desciption = request.POST['description']
    )
    new_book = book
    new_book.save()
    return render(request, "edit.html")