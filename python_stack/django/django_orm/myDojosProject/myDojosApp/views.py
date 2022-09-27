from django.shortcuts import render, redirect, HttpResponse

from .models import *

def dojos(request):
    context = {
        'dojos': Dojo.objects.all()
    }
    return render(request, "dojos.html", context)

def addDojo(request):
    Dojo.objects.create( name = request.POST['name'])
    return redirect('/')
def addNinja(request):
    dojo1 = Dojo.objects.get(id = request.POST['selectADojo'])
    Ninja.objects.create(firstname = request.POST['firstname'], lastname = request.POST['lastname'], dojo = dojo1)
    return redirect('/') 