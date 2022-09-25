from django.urls import path

from . import views

urlpatterns = [
    path('', views.rendForm),
    path('handle', views.handle),
]