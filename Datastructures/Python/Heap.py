import numpy as np

class MinHeap:

    def __init__(self):
        self.capacity = 100
        self.data = np.zeros(100, dtype=int)
        self.size = 0

    def swap(self, i, j):
        tmp = self.data[i]
        self.data[i] = self.data[j]
        self.data[j] = tmp

        
    def insert(self, x):

        n = self.size

        self.data[n] = x
        i = n

        while (0 < i and self.data[i] <= self.data[int(np.floor((i-1)/2))]):
            self.swap(i, int(np.floor((i-1)/2)))
            i = int(np.floor((i-1)/2))

        self.size+=1

    def removeMin(self):

        n = self.size

        x = self.data[0]
        self.data[0] = self.data[n-1]
        i = 0

        while (2*i + 2 < n - 1):
            if (self.data[2*i+1] <= self.data[2*i+2]):
                j = 2*i + 1
            else:
                j = 2*i + 2

            if (self.data[j] <= self.data[i]):
                self.swap(i,j)
                i = j
                continue
            break
        if (2*i + 1 < n-1) and (self.data[2*i+1] <= self.data[i]):
            self.swap(i, 2*i+1)

        self.size-=1


    def printHeap(self):

        print("[ ", end="")
        for i in range(self.size):
            print(f"{self.data[i]} ", end="")

        print("]")


if __name__ == "__main__":

    myHeap = MinHeap()
    myHeap.insert(0)
    myHeap.insert(1)
    myHeap.insert(7)
    myHeap.insert(2)
    myHeap.insert(3)
    myHeap.insert(11)
    myHeap.insert(10)
    myHeap.insert(5)
    myHeap.insert(10)
    myHeap.insert(4)
    myHeap.insert(9)
    myHeap.insert(29)
    myHeap.insert(14)
    myHeap.insert(28)
    myHeap.insert(21)
    myHeap.insert(19)
    myHeap.insert(19)
    myHeap.insert(15)
    myHeap.insert(22)
    myHeap.insert(23)
    myHeap.insert(6)

    myHeap.printHeap()

    myHeap.removeMin()

    myHeap.printHeap()

    myHeap.removeMin()
    myHeap.removeMin()

    myHeap.printHeap()