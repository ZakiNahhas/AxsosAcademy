from django.shortcuts import render, redirect, HttpResponse
from django.contrib import messages

from .models import *

def re_show(request):
    return redirect('/shows')

def show(request):
    return render(request, 'addshow.html')

def create(request):
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
    show1 = Show.objects.get(id = request.POST['hidden'])
    show1.title = request.POST['title']
    show1.network = request.POST['network']
    show1.release_date = request.POST['release_date']
    show1.description = request.POST['description']
    show1.save()
    return redirect(f'shows/{show1.id}')
def all_shows(request):
    context = {
        'shows': Show.objects.all()
    }
    return render(request, 'shows.html', context)
def destroy(request, id):
    show = Show.objects.get(id = id)
    show.delete()
    return redirect('/shows')