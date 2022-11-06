def naughtyWords(str, arr):
    for i in arr:
        str = str.replace(i, (len(i)*"x"))
        str = str.lower()
    return str
print(naughtyWords("Snap crackle pop nincompoop", ["crack","poop"]))