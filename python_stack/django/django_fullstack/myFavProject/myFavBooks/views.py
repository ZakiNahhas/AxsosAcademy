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
    users=User.objects.all()
    for user in users:
        if user.email==request.POST['email']:
            errors['email']="This email already exsists"
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
    user=User.objects.get(id=request.session['user_id'])
    Book.objects.create(
        book_title = request.POST['book_title'],
        description = request.POST['description'],
        uploaded_by = user,
    )
    
    last = Book.objects.last()
    last.liked_by.add(user)
    return redirect('/books')

def edit(request, id):
    book=Book.objects.get(id=id)
    context = {
            "books": Book.objects.all(),
            "book":Book.objects.get(id = id),
            "user":User.objects.get(id=request.session['user_id']),
            "liked_by":book.liked_by.all(),
    }
    return render(request, "edit.html",context)

def add_to_fav(request,id):
    book=Book.objects.get(id=id)
    user=User.objects.get(id=request.session['user_id'])
    book.liked_by.add(user)

    return redirect(f'/books/{id}')

def un_fav(request,id):
    book=Book.objects.get(id=id)
    user=User.objects.get(id=request.session['user_id'])
    book.liked_by.remove(user)

    return redirect(f'/books/{id}')

def update(request,id):
    if request.POST['update'] == 'Update':
        book=Book.objects.get(id=id)
        book.book_title=request.POST['book_title']
        book.description=request.POST['description']
        book.save()
        messages.success(request,"Update Completed successfully!")
        return redirect(f'/books/{id}')
    
    elif request.POST['update'] == 'Delete':
        book=Book.objects.get(id=id)
        book.delete()
        return redirect('/books')