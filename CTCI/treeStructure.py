class Node:
    def __init__(self,value):
        self.value = value
        self.right = None
        self.left = None

class Tree:
    def __init__(self):
        self.root = None

    def addNode(self,node,value):
        if node == None:
            self.root = Node(value)
        else:
            if value < node.value:
                if node.left == None:
                    node.right = Node(value)
                else:
                    self.addNode(node.left,value)
            else:
                if node.right == None:
                    node.right = Node(value)
                else:
                    self.addNode(node.right,value)

    def inorder(self,node):
        if node:
            self.inorder(node.left)
            print(node.value)
            self.inorder(node.right)
        


testTree = Tree()
testTree.addNode(testTree.root, 200)
testTree.addNode(testTree.root, 300)
testTree.addNode(testTree.root, 100)
testTree.addNode(testTree.root, 30)
testTree.inorder(testTree.root)
