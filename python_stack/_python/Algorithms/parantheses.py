str = "hsbd((fffG)s(s))("
def isBalanced(str):
    stack = []
    for i in str:
        if i =='(':
            stack.append(i)
        elif i ==')':
            if len(stack) !=0:
                stack.pop()
            else:
                return "unbalanced"
    if len(stack) == 0:
        return "balanced"
    else: 
        return "unbalanced"
print(isBalanced(str))