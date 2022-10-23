# def count_substring(str, sub_str):
#     count = 0
#     start = 0
#     for i in range(len(str)):
#         findstr = str.find(sub_str, start)
#         if findstr!=-1:
#             start = findstr+1
#             count+=1
#     return count

# print(count_substring("ABSHIZLHIZMSHIZ", "HIZ"))

# def count_substr(string, substr):
#     x = string.rsplit(substr)
#     return len(x)-1

# print(count_substr("HIZASRASGHIZASFHIZ", "HIZ"))

def find_string(string,sub_string):
    count=0
    for i in range(0, len(string)-len(sub_string)+1):
        if string[i] == sub_string[0]:
            flag=1
            for j in range (0, len(sub_string)):
                if string[i+j] != sub_string[j]:
                    flag=0
                    break
            if flag==1:
                count += 1
    return count
print(find_string("ABCDCDC", "CDC"))