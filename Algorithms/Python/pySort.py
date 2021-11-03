import random
import math


class Sorting:

    def __init__(self):
        self.data = []

    def addElements(self,x):
        
        if isinstance(x, int) or isinstance(x, float):
            self.data.append(x)
        else:
            raise TypeError("Can't sort non-number list")

    def printList(self):
        print("[ ", end="")
        for i in self.data:
            print(i," ", end="")

        print("]")
    
    def swap(self,i,j):
        tmp = self.data[i]
        self.data[i] = self.data[j]
        self.data[j] = tmp

    def swapArray(self, A, i, j):
        tmp = A[i]
        A[i] = A[j]
        A[j] = tmp

        return A

    def bubbleSort(self):
        n = len(self.data)
        for i in range(0, n-1):
            for j in range(0, n-i-1):
                if self.data[j] > self.data[j+1]:
                    self.swap(j,j+1)


    def selectionSort(self):
        n = len(self.data)
        for i in range(0, n):
            k = i
            for j in range(i+1, n):
                if self.data[j] < self.data[k]:
                    k = j
            if i != k:
                self.swap(i,k)

    def insertionSort(self):
        n = len(self.data)
        for i in range(1, n):
            j = i
            while (j > 0 and self.data[j-1] > self.data[j]):
                self.swap(j-1, j)
                j -= 1

    def _merge(self, A1, A2, A):
        i = 0
        j = 0

        while i < len(A1) and j < len(A2):
            if A1[i] < A2[j]:
                A[i+j] = A1[i]
                i += 1
            else:
                A[i+j] = A2[j]
                j += 1
        
        while i < len(A1):
            A[i+j] = A1[i]
            i += 1

        while j < len(A2):
            A[i+j] = A2[j]
            j += 1
        
        return A

    def _mergeSort(self, A):

        n = len(A)

        if n <= 1:
            return A

        i = math.floor(n/2)

        A1 = self._mergeSort(A[0:i])
        A2 = self._mergeSort(A[i:n])

        return self._merge(A1, A2, A)

    def mergeSort(self):

        self.data = self._mergeSort(self.data)


    def _partition(self, A, low, high):
        n = len(A)
        p = math.floor(n/2)
        self.swapArray(A, p, high)

        pivot = A[high]
        left = low
        right = high-1

        while left <= right:
            while left <= right and A[left] <= pivot:
                left += 1

            while right >= left and A[right] >= pivot:
                right -= 1

            if left < right:
                A = self.swapArray(A, left, right)

        A = self.swapArray(A, left, high)
        return left

    def _quickSort(self, A, low, high):
        if low >= high:
            return A

        p = self._partition(A, low, high)
        self._quickSort(A, low, p-1)
        self._quickSort(A, p+1, high)

        return A

    def quickSort(self):

        n = len(self.data)
        self.data = self._quickSort(self.data, 0, n-1)
        



if __name__ == "__main__":

    s = Sorting()
    for i in range(0, 10):
        s.addElements(random.randint(0, 10))

    s.printList()
    s.quickSort()
    s.printList()
