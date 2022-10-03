# queue = [1,3,4,5,8,20]
# queue.append(90)
class Queue:
        def __init__(self, queue):
            self.queue = []        
        def contains(self, val):
            for i in self.queue:
                if i == val:
                    return True
            else:
                return False
        
        def front(self):
                return self.queue[0]
            
        def enqueue(self, value):
            self.queue.insert(0, value)
        
        def dequeue(self):
                return self.queue.pop(0)
        
        def print(self):
            for i in range(len(self.queue)):
                print(self.queue[i])
                
                
zaki=Queue([1,2,3,5])
zaki.enqueue(10)
zaki.enqueue(15)
zaki.print()
print(zaki.dequeue())
print(zaki.contains(10))

print(zaki.front())