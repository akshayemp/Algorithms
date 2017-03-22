# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isSameTree(self, p, q):
        """
        :type p: TreeNode
        :type q: TreeNode
        :rtype: bool
        """
        if p == None and q == None:
            return True
        if p == None or q == None:
            return False
        while p != None or q != None:
            b = (p.val == q.val)
            if b == False:
                return False
            pb = self.isSameTree(p.left,q.left)
            qb = self.isSameTree(p.right, q.right)
            return (pb & qb)
        
