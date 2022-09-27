from django.urls import path

from . import views

urlpatterns = [
    path('', views.index),
    path('add_book', views.add_book),
    path('books/<int:id>', views.view_books),
    path('auth_to_book/<int:id>', views.auth_to_book),
     path('add_author', views.add_author),
    path('authors/<int:id>', views.view_authors),
    path('book_to_auth/<int:id>', views.book_to_auth),
    path('authors',views.authors)
]