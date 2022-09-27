from django.urls import path

from . import views

urlpatterns = [
    path('', views.index),
    path('addBook', views.addBook),
    path('books/<int:id>', views.viewBooks),
    path('pubToBook/<int:id>', views.pubToBook),
]