from django.shortcuts import render, HttpResponse, redirect
from urllib import request
def count(request):
    if 'count' in request.session:
        request.session['count']=request.session.get('count')+1
    else:
        request.session['count']=1
    return render(request, "counter.html")
def destroy(request):
    # session.clear() # Destroy All sessions
    request.session.pop('count', None)
    return render(request, "counter.html")
def increment2(request):
    request.session['count']=request.session.get('count')+1
    return redirect('/')
def reset(request):
        request.session['count']=0
        return redirect('/')