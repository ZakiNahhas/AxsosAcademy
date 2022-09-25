from django.shortcuts import render, redirect, HttpResponse

from .models import User

def rendForm(request):
    context = {
        'users':User.objects.all() 
    }
    return render(request, 'form.html', context)
def handle(request):
    User.objects.create(firstname=request.POST['firstname'], lastname=request.POST['lastname'], email_address=request.POST['email'], age = request.POST['age'])
    return redirect('/')
