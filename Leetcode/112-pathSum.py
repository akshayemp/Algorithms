# Definition for a binary tree node.

# class TreeNode(object):

#     def __init__(self, x):

#         self.val = x

#         self.left = None

#         self.right = None



class Solution(object):

    def hasPathSum(self, root, sum):

        """

        :type root: TreeNode

        :type sum: int

        :rtype: bool

        """

        if root == None:

            return False

        if (root.left == None) & (root.right == None) & (root.val == sum):

            return True

        if root.left is not None:

            flag = self.hasPathSum(root.left,sum-root.val)

            if flag == True:

                return flag

        flag = self.hasPathSum(root.right,sum-root.val)

        return flag
