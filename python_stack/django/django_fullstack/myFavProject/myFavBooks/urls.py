from django.urls import path, include

from . import views

urlpatterns = [
    path('', views.index),
    path('register', views.register),
    path('login', views.login),
    path('logout', views.logout),
    path('books', views.books),
    path('add_book', views.add_book),
    path('books/<int:id>', views.edit),
    path('add_to_fav/<int:id>', views.add_to_fav),
    path('un_fav/<int:id>', views.un_fav),
    path('update/<int:id>', views.update)
]