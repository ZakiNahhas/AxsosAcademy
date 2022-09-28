from django.urls import path

from . import views

urlpatterns = [
    path('', views.re_show),
    path('shows/new', views.show),
    path('create', views.create),
    path('shows/<int:id>', views.displayShow),
    path('shows/<int:id>/edit', views.edit),
    path('update', views.update),
    path('shows', views.all_shows),
    path('shows/<int:id>/destroy', views.destroy)
]