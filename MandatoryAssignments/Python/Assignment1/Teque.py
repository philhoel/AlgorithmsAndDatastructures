import math

class Node:

    def __init__(self, x, n, p):
        self.data = x
        self.next = n
        self.prev = p

class Teque:

    def __init__(self):
        self.head = None
        self.tail = None
        self.size = 0

    def pushBack(self, x):
        
        if self.head is None:
            self.head = Node(x, None, None)
            self.tail = self.head
            self.size += 1
            return

        current = Node(x, None, self.tail)
        self.tail = current
        self.size += 1


    def pushFront(self, x):
        
        if self.head is None:
            self.head = Node(x, None, None)
            self.tail = self.head
            self.size += 1
            return

        current = Node(x, self.tail, None)
        self.head = current
        self.size += 1

    def pushMiddle(self, x):
        if self.head is None:
            self.head = Node(x, None, None)
            self.tail = self.head
            self.size += 1
            return

        current = self.head
        for i in range(math.floor((self.size + 1)/2) - 1):
            current = current.next
            #print(current.data)
        
        tmp = Node(x, current.next, current.prev)
        temp = current.next
        current.next = tmp
        temp.prev = tmp

        self.size += 1
        

    def get(self, index):
        if self.head is None:
            print("Queue is empty")

        if index <= math.floor((self.size + 1)/2):
            current  = self.head
            for i in range(index):
                current = current.next
            
            return current.data

        if index > math.floor((self.size + 1)/2):
            current  = self.tail
            for i in range(index, 0, -1):
                current = current.prev
            
            return current.data

    def printTeque(self):
        if self.head is None:
            print("Queue is empty")
            return

        print("[ ", end="")
        current = self.head
        while (current is not None):
            print(current.data, end=" ")
            current = current.next

        print("]")

if __name__ == "__main__":

    myTeque = Teque()
    myTeque.pushBack(9)
    myTeque.pushFront(3)
    myTeque.pushMiddle(5)

    print(myTeque.get(0))
    print(myTeque.get(1))
    print(myTeque.get(2))

    myTeque.pushMiddle(1)

    myTeque.get(1)
    myTeque.get(2)
    #print(myTeque.size)

    myTeque.printTeque()