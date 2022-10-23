from django.urls import path, include

from . import views

urlpatterns = [
    path('', views.index),
    path('register', views.register),
    path('login', views.login),
    path('logout', views.logout),
    path('dashboard', views.dashboard),
    path('plant_a_tree', views.plant_a_tree),
    path('new/tree', views.plant),
    path('plant_me', views.plant_me),
    path('details/<int:id>', views.details),
    path('my_trees', views.my_trees),
    path('delete/<int:id>', views.delete),
    path('edit/<int:id>', views.edit),
    path('update/<int:id>', views.update),
    
]