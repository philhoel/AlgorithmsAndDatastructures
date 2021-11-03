import random

class Node:

    def __init__(self, x, l=None, r=None):
        self.value = x
        self.left = l
        self.right = r

class RecursiveBST:

    def __init__(self):
        self.root = None
        self.count = 0

    def _addNode(self, x, v):

        if v is None:
            return Node(x)

        if x >= v.value:
            v.right = self._addNode(x, v.right)

        if x < v.value:
            v.left = self._addNode(x, v.left)

        return v

    def addNode(self, x):

        if self.root is None:
            self.root = Node(x)
            self.count += 1

        self._addNode(x, self.root)


    def _printTree(self, v):

        if v is None:
            return

        self._printTree(v.left)
        print(v.value, " ", end="")
        self._printTree(v.right)


    def printTree(self):

        if self.root is None:
            print("The tree is empty!")
            return
        
        print("[ ", end="")
        self._printTree(self.root)
        print("]")


if __name__ == "__main__":

    myTree = RecursiveBST()

    for i in range(0, 10):
        myTree.addNode(random.randint(0, 10))

    myTree.printTree()