'''
Implementation of trees.
'''
class BinaryTree:
    def __init__(self,rootObj):
        self.key = rootObj
        self.leftChild = None
        self.rightChild = None

    def insertLeft(self, newNode):
        if self.leftChild == None:
            self.leftChild = BinaryTree(newNode)
        else:
            t = BinaryTree(newNode)
            t.leftChild = self.leftChild
            self.leftChild = t

    def insertRight(self, newNode):
        if self.rightChild == None:
            self.rightChild = BinaryTree(newNode)
        else:
            t = BinaryTree(newNode)
            t.rightChild = self.rightChild
            self.rightChild = t

    def getRightChild(self):
        return self.rightChild
    def getLeftChild(self):
        return self.leftChild

    def setRootVal(self,obj):
        self.key = obj

    def getRootVal(self):
        return self.key

r = BinaryTree('a')
print(r.getRootVal())
print(r.getLeftChild())
r.insertLeft('b')
print(r.getLeftChild())
print(r.getLeftChild().getRootVal())

def buildTree():
    r = BinaryTree('a')
    r.insertLeft('b')
    r.insertRight('c')
    r.getLeftChild().insertRight('d')
    r.getRightChild().insertLeft('e')
    r.getRightChild().insertRight('f')
    return r
def testEqual(x,y):
    print(x == y)
ttree = buildTree()
testEqual(ttree.getRightChild().getRootVal(),'c')
testEqual(ttree.getLeftChild().getRightChild().getRootVal(),'d')
testEqual(ttree.getRightChild().getLeftChild().getRootVal(),'e')

