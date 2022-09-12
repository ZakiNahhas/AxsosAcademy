# biggie_size
from types import CoroutineType


# def biggie_size(list):
#     for i in range(len(list)):
#         if(list[i] > 0):
#             list[i] = "BIG"
#     return list
# print(biggie_size([-1,2,5,-3]))

# count positives
def countPos(list):
    count =0
    for i in range(len(list)):
        if list[i] > 0:
            count+=1
        list[len(list)-1] = count
    return list
print(countPos([3,6,-4,-2,-7,-2]))