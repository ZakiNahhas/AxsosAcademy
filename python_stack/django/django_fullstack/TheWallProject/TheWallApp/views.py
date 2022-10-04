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
    if 'user_id' in request.session:
            return render(request,'wall.html',context)
    else:
            return render(request,'form.html')

def create_message(request):
    Message.objects.create(
        message_content=request.POST['message_content'],
        user=User.objects.get(id=request.session['user_id'])
    )
    return redirect('/wall')
def create_comment(request):
    userid=User.objects.get(id=request.session['user_id'])
    messageid=Message.objects.get(id=int(request.POST['hide2']))
    # print(Message.objects.get(id=intrequest.POST['hide2']).__dict__)
    Comment.objects.create(
        comment_content=request.POST['comment_content'],
        user=userid,
        messages= messageid,
    )
    return redirect('/wall')

def deletemsg(request):
    message=Message.objects.get(id=int(request.POST['hide1']))
    message.delete()
    return redirect('/wall')