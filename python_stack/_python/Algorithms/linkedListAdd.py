from locale import currency


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
                    
list1 = LinkedList()
list1.head = Node(141)
n2 = Node(142)
n3 = Node(143)
n4 = Node(144)
list1.head.next = n2
n2.next = n3
n3.next = n4
list1.insertNodeAtTail(145)
list1.traverse()

# delete = current.next = current.next.next