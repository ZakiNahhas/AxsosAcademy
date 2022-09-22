import random
from django.shortcuts import render, HttpResponse, redirect
def number(request):
    randomNumber = random.randint(1,100)
    request.session['random']=randomNumber
    request.session['result']=''

    return render(request, 'index.html')
def result(request):
    yourNumber = int(request.POST['submitted'])
    if yourNumber == request.session['random']:
        request.session['result'] = "Was the right number"
    elif yourNumber > request.session['random']:
        request.session['result'] = "Too High"
    else:
        request.session['result'] = "Too Low"
    return redirect('/reset')
def reset(request):
    return render(request, 'index.html')
def playAgain(request):
    return render(request,'index.html')