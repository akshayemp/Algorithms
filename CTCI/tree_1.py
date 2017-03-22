class Node:
    def __init__(self,key):
        self.data = key
        self.left = None
        self.right = None

    def minDepth(root):
        if root is None:
            return 0

        if root.left is None and root.right is None:
            return 1

        if root.left is None:
            return minDepth(root.left)+1
        if root.right is None:
            return minDepth(root.left)+1

        return min(minDepth(root.left),minDepth(root.right)) +1

    def maxPath(root):
        
