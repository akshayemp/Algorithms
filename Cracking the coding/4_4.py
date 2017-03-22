class TreeNode():
    def __init__(self,x):
        self.val = x
        self.right = None
        self.left = None

def levelOrder(root):
    if not root:
        return []
    ans,level = [],[root]
    while level:
        ans.append([node.val for node in level])
        temp = []
        for node in level:
            temp.extend([node.left,node.right])
        level = [leaf for leaf in temp if leaf]
    return ans
        
        
        
        
