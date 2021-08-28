
class Node:

    def __init__(self, x, n=None):
        self.x = x
        self.next = n

class LinkedList:

    def __init__(self):
        self.size = 0
        self.head = None
        
    def append(self, x):
        if (self.head is None):
            self.head = Node(x)
            self.size += 1
            return

        current = self.head
        while (current.next is not None):
            current = current.next

        current.next = Node(x)
        self.size += 1
    
    def printOut(self):

        print("[ ", end="")
        current = self.head
        while (current is not None):
            print(current.x, end=" ")
            current = current.next

        print("]")




if __name__ == "__main__":

    myList = LinkedList()
    myList.append(1)
    myList.append(2)
    myList.append(3)
    myList.append(4)
    myList.append(5)

    myList.printOut()

