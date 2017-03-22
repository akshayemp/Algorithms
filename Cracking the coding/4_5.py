
class TreeNode():
    def __init__(self,x):
        self.val = x
        self.right = None
        self.left = None

def find_succ(node):
    if node:
        p = node.parent if node.parent
        if node.right:
            return leftMostChild(node.right)
        else:
            while p:
                if p.left == node:
                    break
                node = p
        return p
    return
                
                
