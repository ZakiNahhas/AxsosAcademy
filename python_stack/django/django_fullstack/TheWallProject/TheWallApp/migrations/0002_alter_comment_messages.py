# Generated by Django 4.1.1 on 2022-10-04 08:29

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    dependencies = [
        ('TheWallApp', '0001_initial'),
    ]

    operations = [
        migrations.AlterField(
            model_name='comment',
            name='messages',
            field=models.ForeignKey(null=True, on_delete=django.db.models.deletion.CASCADE, related_name='comments', to='TheWallApp.message'),
        ),
    ]
