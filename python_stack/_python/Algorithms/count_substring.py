def count_substring(str, sub_str):
    count = 0
    start = 0
    for i in range(len(str)):
        findstr = str.find(sub_str, start)
        if findstr!=-1:
            start = findstr+1
            count+=1
    return count

print(count_substring("ABSHIZLHIZMSHIZ", "HIZ"))