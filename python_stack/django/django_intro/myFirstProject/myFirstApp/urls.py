from django.urls import path
from . import views
urlpatterns = [
    path('', views.method1),
    path('hello/<id>', views.method2),
    path('file', views.method3),
    path('form', views.rendForm),
    path('handlesubmit', views.handle),
]
