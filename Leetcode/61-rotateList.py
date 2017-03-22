# Definition for singly-linked list.

# class ListNode(object):

#     def __init__(self, x):

#         self.val = x

#         self.next = None



class Solution(object):

    def rotateRight(self, head, k):

        """

        :type head: ListNode

        :type k: int

        :rtype: ListNode

        """

        if head == None:

            return None

        if head.next == None:

            return head

        nodes = []

        p = ListNode(None)

        p.next = head

        q = p

        while q.next is not None:

            q = q.next

            nodes.append(q)

        k %= len(nodes)

        if k == 0:

            return head

        newHead = nodes[-k]

        nodes[-k - 1].next = None

        nodes[-1].next = head

        return newHead
