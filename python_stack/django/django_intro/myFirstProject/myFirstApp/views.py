from django.shortcuts import render, HttpResponse, redirect
from .models import User

# Create your views here.
def method1(request):
    return HttpResponse('Hello world from Django app 1')

def method2(request, id):
    return HttpResponse('Hello'+ str(id))

def method3(request):
    context = {
        'var1': "Zaki",
        'var2': 7,
        'var3': [1,2,3,4,5]
    }
    return render(request, 'index.html', context)
def rendForm(request):
    return render(request, 'form.html')
def handle(request):
    User.objects.create(username=request.POST['Username'], email=request.POST['Email'], color=request.POST['fav'])
    return redirect('first')
def visits(request):
    if 'counter' not in request.session:
        request.session['counter']= 1
    else:
        request.session['counter']=+1
    return render(request, 'something.html')