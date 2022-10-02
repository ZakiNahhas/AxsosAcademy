from django.shortcuts import render, redirect, HttpResponse
from django.contrib import messages

from myTvShowsApp.forms import ShowForm

from .models import *

def show_unique(request):
    show = ShowForm(request.POST or None)
    if form.is_valid():
        form.save()  
        form = ShowForm()
    else:
        return HttpResponse("kjkkk")
    return render(request,'shows.html',{'form':show})

def re_show(request):
    return redirect('/shows')

def show(request):
    return render(request, 'addshow.html')

def create(request):
    
    errors = Show.objects.basic_validator(request.POST)
    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)
        return redirect('/shows/new')
    
    else:
        
        Show.objects.create(
        title = request.POST['title'],
        network = request.POST['network'],
        release_date = request.POST['release_date'], 
        description = request.POST['description']
        )
    show = Show.objects.last()
    return redirect(f'shows/{show.id}')
    

def displayShow(request, id):
    context = {
        'show': Show.objects.get(id = id)
    }
    return render(request, 'resultOfCreation.html', context)
def edit(request, id):
    context = {
        'show': Show.objects.get(id = id)
    }
    return render(request, 'edit.html', context)
def update(request):
    errors = Show.objects.basic_validator(request.POST)
    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)
        return render(request, 'edit.html')
    else:
        show = Show.objects.get(id = request.POST['hidden'])
        show.title = request.POST['title']
        show.network = request.POST['network']
        show.release_date = request.POST['release_date']
        show.description = request.POST['description']
        show.save()
        return redirect(f'shows/{show.id}')
def all_shows(request):
    context = {
        'shows': Show.objects.all()
    }
    return render(request, 'shows.html', context)
def destroy(request, id):
    show = Show.objects.get(id = id)
    show.delete()
    return redirect('/shows')