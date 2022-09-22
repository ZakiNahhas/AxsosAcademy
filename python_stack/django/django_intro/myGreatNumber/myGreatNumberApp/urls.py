from django.urls import path
from . import views
urlpatterns = [
    path('', views.number),
    path('number', views.result),
    path('reset', views.reset),
    path('result', views.playAgain),
]