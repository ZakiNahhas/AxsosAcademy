import random
def randInt(min=0, max=100):
    num = ((random.random()) * (max-min)) + min 
    return num

print(randInt(0, 1))
print(randInt(max=50)) 	
print(randInt(min=50)) 
print(randInt(min=50, max=500))