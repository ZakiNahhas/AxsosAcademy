from django.shortcuts import render, HttpResponse

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
    context = {
        'Username': request.POST['Username'],
        'Email': request.POST['Email'],
        'fav': request.POST['fav']
    }
    return render(request, 'result.html', context)