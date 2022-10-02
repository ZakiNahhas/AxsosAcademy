queue = [1,3,4,5,8,20]
queue.append(90)

class Queue:
        def __init__(self,queue):
            self.queue = queue

            
        def contains(self, val):
            for i in self.queue:
                if i == val:
                    return True
            else:
                return False
        
        def front(self):
                return self.queue[0]
zaki=Queue([1,2,3,5])
zaki.front()
print(zaki.front())
print(zaki.contains(5))

