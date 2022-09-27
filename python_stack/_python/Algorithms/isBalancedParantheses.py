
def isBalanced(str):
    str = "hsbd((fffG)s(s)){}{"
    opened = ['(', '{', "["]
    closed = [')', '}', ']']
    stack = []
    for i in str:
        if i in opened:
            stack.append(i)
        elif i in closed:
            index = closed.index(i)
            if stack[len(stack)-1] == opened[index]:
                stack.pop()
            else:
                return "unbalanced"
    if len(stack) == 0:
        return "balanced"
    else: 
        return "unbalanced"
print(isBalanced(str))