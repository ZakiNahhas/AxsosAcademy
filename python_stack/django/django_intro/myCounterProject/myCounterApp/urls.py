from django.urls import path
from . import views
urlpatterns = [
    path('', views.count),
    path('destroy', views.destroy),
    path('increment2', views.increment2),
    path('reset', views.reset),
    
]