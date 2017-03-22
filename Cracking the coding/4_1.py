def max_depth(root):
    if root == None:
        return
    return 1+max(max_depth(root.left),max_depth(root.right))

def min_depth(root):
    if root == None:
        return
    return 1+min(min_depth(root.left), min_depth(root.right))

def isBalanced(root):
    return (max_depth(root) - min_depth(root) <= 1)
