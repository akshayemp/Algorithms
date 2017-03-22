class TreeNode():
    def __init__(self,value):
        self.value = value
        self.left = None
        self.right = None
class Tree():
    def __init__(self):
        self.root = None
    
    def insert(self,value):
        if self.root == None:
            self.root = TreeNode(value)
        else:
            while self.root != None:
                if self.root.left == None:
                    self.root.left = TreeNode(value)
                    return
                elif self.root.right == None:
                    self.root.right = TreeNode(value)
                    return
                elif (self.root.left != None & self.root.right != None):
                    self.root = self.root.left
            
