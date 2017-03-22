A = [1,2,3,4,5,6,7]

class TreeNode():
    def __init__(self,x):
        self.val = x
        self.right = None
        self.left = None

def build_tree(A,start,end):
    if end < start:
        return []
    mid = (start+end)//2
    node = TreeNode(A[mid])
    node.left = build_tree(A,start,mid-1)
    node.right = build_tree(A,mid+1,end)
    return node

build_tree(A,0,len(A)-1)
