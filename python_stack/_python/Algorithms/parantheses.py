def paranth(str):
    count1 = 0;
    count2 = 0;
    for i in range(0, len(str)):
        if(str[0]==")"):
            return False
        if(str[len(str)-1]=="("):
            return False
        if(str[i] == "("):
            count1+=1
        elif(str[i] == ")"):
            count2+=1
    if(count1==count2):
        return True
    else:
        return False

print(paranth("(sdff)(sdghn)))((("))