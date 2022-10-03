from django.shortcuts import render, redirect
from django.contrib import messages
from .models import *
from myLoginApp.models import *

# Create your views here.
def wall(request):
    context = {
        'messages': Message.objects.all(),
        'comments': Comment.objects.all()
    }
    if 'userid' in request.session:
            return render(request,'wall.html',context)
    else:
            return render(request,'form.html',context)

def create_message(request):
    Message.objects.create(
        message_content=request.POST['message_content'],
        user=User.objects.get(id=request.session['userid'])
    )
    return redirect('/wall')
def create_comment(request):
    Comment.objects.create(
        comment_content=request.POST['comment_content'],
        user=User.objects.get(id=request.session['userid']),
        message=Message.objects.get(id=request.POST['hide2'])
    )
    return redirect('/wall')

def deletemsg(request):
    
    message=Message.objects.get(id=request.POST['hide1'])
    message.delete()
    return redirect('/wall')