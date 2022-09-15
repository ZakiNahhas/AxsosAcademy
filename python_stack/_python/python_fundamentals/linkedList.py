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
            
list1=LinkedList()
list1.head=Node("Zaki")
list1.head.next=Node("Yosef")
list1.head.next.next=Node("Shalash")
list1.head.next.next.next=Node("Laith")
list1.traverse()