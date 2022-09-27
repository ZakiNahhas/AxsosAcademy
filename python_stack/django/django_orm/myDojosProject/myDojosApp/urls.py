from django.urls import path

from . import views

urlpatterns = [
    path('', views.dojos),
    path('addDojo', views.addDojo),
    path('addNinja', views.addNinja),
]