from django.shortcuts import render, redirect, HttpResponse
from django.contrib import messages
from .models import *
import bcrypt

def index(request):
    return render(request, "registration.html")

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
    return redirect('/dashboard')

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
    return redirect('/dashboard')

def logout(request):
    request.session.clear()
    return redirect('/')

def dashboard(request):
    context = {
        'users': User.objects.all(),
        'trees': Tree.objects.all(),
    }
    return render(request, "dashboard.html", context)

def plant(request):
    return render(request, "arbotrary.html")

def plant_a_tree(request):
    return redirect('/plant')

def plant_me (request):
    errors = Tree.objects.validator(request.POST)
    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)
        return redirect('/new/tree')
    
    else:
        user=User.objects.get(id=request.session['user_id'])
        Tree.objects.create(
        species = request.POST['species'],
        location = request.POST['location'],
        reason = request.POST['reason'], 
        date_planted = request.POST['date_planted'],
        planted_by = user
        )
        
    last = Tree.objects.last()
    return redirect('/dashboard')

def details(request, id):
    user=User.objects.get(id=request.session['user_id'])
    tree=Tree.objects.get(id=id)
    context = {
        'tree':Tree.objects.get(id=id),
        'user':user,
    }
    return render(request,'details.html', context)

def my_trees(request):
    user=User.objects.get(id=request.session['user_id'])
    context = {
        'user':user,
    }
    return render(request, "my_trees.html", context)

def delete(request, id):
    tree = Tree.objects.get(id = id)
    tree.delete()
    return redirect('/my_trees')

def update(request, id):
    context = {
        'tree': Tree.objects.get(id = id)
    }
    return render(request, "update.html", context)

def edit(request, id):
    errors = Tree.objects.validator(request.POST)
    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)
        return render(request, 'my_trees.html')
    else:
        tree = Tree.objects.get(id = id)
        tree.species = request.POST['species']
        tree.location = request.POST['location']
        tree.reason = request.POST['reason']
        tree.date_planted = request.POST['date_planted']
        tree.save()
        return redirect('/dashboard')