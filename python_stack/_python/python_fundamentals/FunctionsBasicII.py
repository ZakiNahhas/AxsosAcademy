# Countdown
# def countdown(number):
#     list = []
#     while number > 0:
#         list.append(number)
#         number-=1
#     return list
        
# print(countdown(5))

# Print and Return
# def printandReturn(list):
#     print(list[0])
#     return list[1]

# print(printandReturn([5, 6]))

# First Plus Length
# def firstPluslength(list):
#     return list[0] + list[len(list)-1]

# print(firstPluslength([1,2,3,4,5]))

# Values Greater than Second
# def valuesGreaterThan(list):
#     if len(list) < 2:
#         return False
#     newList = []
#     for val in list:
#         if(val > list[1]):
#             newList.append(val)
#     print(len(newList))
#     return newList
# print(valuesGreaterThan([5,2,3,2,1,4]))

# This Length, That Value
def thisLengthThatValue(size, value):
    list = []
    count = size
    while count > 0:
        list.append(value)
        count-=1
    return list
print(thisLengthThatValue(4, 7))    