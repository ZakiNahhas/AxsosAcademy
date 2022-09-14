# biggie_size
def biggie_size(list):
    for i in range(len(list)):
        if(list[i] > 0):
            list[i] = "BIG"
    return list
print(biggie_size([-1,2,5,-3]))

#################################################

# count positives

def countPos(list):
    count =0
    for i in range(len(list)-1,-1,-1):
        if list[i] > 0:
            count+=1
        list[len(list)-1] = count
    return list
print(countPos([3,6,-4,-2,-7,-2]))

#################################################

# Sum total

def sumTotal(list):
    sum = 0
    for i in range(len(list)):
        sum += list[i]
    return sum
print(sumTotal([1,2,3,4]))

#################################################

# Average

def getAverage(list):
    avg = 0
    for i in range(len(list)):
        avg += list[i] / len(list)
    return avg
print(getAverage([1,2,3,4]))

#################################################

# length

def getLength(list):
        return len(list)
print(getLength([]))

#################################################

# minimum

def getMinmum(list):
    if len(list)> 0:
        min=list[0]
        for i in range(len(list)):
            if list[i] < min:
                min = list[i]
    else:
        return False
    return min
print(getMinmum([1,2,3,4]))

#################################################

# maximum

def getMaximum(list):
    if len(list)>0:
        max=list[0]
        for i in range(len(list)):
            if list[i] > max:
                max = list[i]
    else:
        return False
    return max
print(getMaximum([1,2,3,4]))

#################################################

# Ultimate

def ultimateAnalysis(list):
    sum = 0
    avg = 0
    min = list[0]
    max = list[0]
    for i in range(len(list)):
        sum += list[i]
        avg += list[i] / len(list)
        if list[i] < min:
            min = list[i]
        if list[i] > max:
            max = list[i]
    dictionary = {'sumTotal ': sum, 'average': avg,
                  'minimum': min, 'maximum': max}
    return dictionary

print(ultimateAnalysis([1, 2, 3, 4]))

#################################################

# reverse

def reverseList(list):
    reversed_list = list[::-1]
    return reversed_list


print(reverseList([1, 2, 3, 4]))
