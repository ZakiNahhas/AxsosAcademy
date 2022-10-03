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
    return render(request, "wall.html", context)

def create_message(request):
    user = User.objects.get(id = request.session['userid'])
    Message.objects.create(
        message_content = request.POST['message_content'],
        user=user
    )
    return redirect('/wall')
def create_comment(request):
    user = User.objects.get(id = request.session['userid'])
    Comment.objects.create(
        comment_content = request.POST['comment_content'],
        user=user
    )
    return redirect('/wall')