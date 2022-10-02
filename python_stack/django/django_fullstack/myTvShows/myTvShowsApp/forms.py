from django.forms import ModelForm
from .models import Show
from django import froms

class ShowForm(ModelForm):  
    class Meta:  
        model = Show 
        fields = ['title']
def clean_title(self):
    title = self.request.POST.get('title')
    username = self.cleaned_data.get('username')
    if title and Show.objects.filter(title=title).exists():
        raise ValidationError(u'Email addresses must be unique.')
    return title