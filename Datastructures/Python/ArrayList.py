import numpy as np

class ArrayList:

    def __init__(self):
        self.capacity = 10
        self.data = np.zeros(self.capacity)
        self.size = 0

    def _resize(self):
        self.capacity *= 2
        tmp = np.zeros(capacity)
        for i in range(self.size):
            tmp[i] = self.data

        self.data = tmp


    def append(self, x):

        if (self.size == self.capacity):
            self._resize()

        self.data[self.size] = x
        self.size += 1

    def insert(self, x, i):
        pass

    def remove(self, i):
        pass

    def print(self):

        print("[ ", end="")
        for i in range(self.size):
            print(f"{self.data[i]} ")

        print("]")