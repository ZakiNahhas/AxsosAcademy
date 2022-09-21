class Node:
    def __init__(self, value):
        self.value = value
        self.next = None 
class LinkedList:
    def __init__(self):
        self.head = None
    def traverse(self):
        current=self.head
        while current is not None:
            print(current.value)
            current=current.next
    def insertNodeAtTail(self, value):
        if self.head == None:
            self.head=Node(value)
        else: 
            current = self.head
            while current.next is not None:
                current = current.next
            current.next = Node(value)
    def deleteNode(self, position):
        if position == 0:
         temp = self.head
         self.head = self.head.next
         temp = None
        else:
            current=self.head
            for x in range(position-1):
                current= current.next
            current.next = current.next.next
    def reverseList(self):
        previous = None
        current = self.head
        while current is not None:
            nextNode = current.next
            current.next = previous
            previous = current
            current = nextNode
        self.head= previous
        # current = self.head
        # list_ = [current.value]
        # while current.next is not None:
        #     current = current.next
        #     list_.append(current.value)
        # return list_[::-1]
    def insertAtPos(self, value, pos):
        
        if pos == 1:
            Node1 = Node(value)
            Node1.next = self.head
            self.head = Node1
        else:
            current = self.head
            for i in range(pos-1):
                current = current.next
            Node1= Node(value)
            Node1.next = current.next
            current.next = Node1
            
        # if midNode is None:
        #     print("LinkedList is empty")
        #     return
        # newNode = Node(newNode)
        # newNode.next = midNode.next
        # midNode.next = newNode
    
    
    
    
        
              

                
                    
list1 = LinkedList()
list1.head= Node(141)
n2 = Node(142)
n3 = Node(143)
n4 = Node(144)
list1.head.next = n2
n2.next = n3
n3.next = n4
# list1.insertNodeAtTail(145)
# list1.deleteNode(2)
# list1.traverse()
list2 = LinkedList()
list1.reverseList()
list1.insertAtPos(146, 4)
list1.traverse()

# for elem in list1.revList():
#     list2.insertNodeAtTail(elem)
    
# list2.traverse()