# Basics 
for x in range(0, 151, 1):
    print(x)

# Multiples of Five
for y in range(0, 1005, 1):
    if y % 5 == 0:
        print(y)

# Counting, the Dojo Way
for y in range(1, 100, 1):
    if y % 5 == 0:
        print("Coding")
    elif y % 10 == 0:
        print("Coding Dojo")

# Whoa. That Sucker's Huge
for z in range(0, 500000, 1):
    sum = 0
    if z % 2 == 1:
        sum+=z
print(sum)

# Countdown by Fours
number = 2018
while number > 0:
        print (number)
        number = number - 4

# Flexible Counter
def flexibleCounter(lowNum, highNum, mult):
    list = []
    for i in range(lowNum, highNum):
        if i % mult == 0:
            list.append(i)
    return list
print(flexibleCounter(2,9,3))