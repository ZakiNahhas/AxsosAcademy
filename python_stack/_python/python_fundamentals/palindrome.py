def isPalindrome(list):
    l = int(len(list)/2)
    first = 0
    last = len(list)-1
    for i in range(0, l, 1):
        if list[first] == list[last]:
            first+=1
            last-=1
            return True
    else: return False
    
print(isPalindrome("malayalam"))

##################################
