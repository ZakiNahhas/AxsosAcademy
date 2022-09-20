import json
from django.shortcuts import render, HttpResponse, redirect
from django.http import JsonResponse
# Create your views here.
def root(request):
    return redirect('/blogs')
def index(request):
    return HttpResponse('placeholder to later display all blogs')
def new(request):
    return HttpResponse("placeholder to display a new form to create a new blog")
def create(request):
    return redirect('/')
def show(request, num):
    return HttpResponse("placeholder to display blog number: " + str(num))
def edit(request, num):
    return HttpResponse("placeholder to edit blog: " + str(num))
def destroy(request, num):
    return redirect('/blogs')
def showJson(request):
    return JsonResponse({"title": "sadasf gsa sggsag", "content": 'saff',"status":True})
