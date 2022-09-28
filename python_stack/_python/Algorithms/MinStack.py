class MinStack:
    def __init__(self):
        self.stack = []
        self.min = 0.0
        # self.min = []
        
    def push(self, value):
        if value<=self.min:
            self.stack.append(min)
            self.min = value
            self.stack.append(value)
            
            # self.stack.append(value)
            # if len(self.stack) !=0:
            #     mymin = min(value, self.min[-1])
            # else:
            #     mymin = value
            # self.min.append(mymin)
            
    def pop(self):
        t = self.stack[-1]
        self.stack.pop()
        if self.min == t:
            self.min = self.stack[-1]
            self.stack.pop()
            
            # self.stack.pop()
            # self.min.pop()
            
    def top(self):
        return self.stack[-1]
    
    def getMin(self):
        return self.min
        # print(self.min[-1])

newStack = MinStack()
newStack.push(-6)
newStack.push(10)
newStack.push(5)
newStack.push(-2)
newStack.pop()
print(newStack.getMin())

    