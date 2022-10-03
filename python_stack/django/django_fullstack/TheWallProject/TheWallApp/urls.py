from django.urls import path,include

from myLoginApp import views
from . import views
urlpatterns = [
    path('/', views.wall),
    path('/create_message', views.create_message),
    path('/create_comment', views.create_comment),
    path('/deletemsg', views.deletemsg)
]