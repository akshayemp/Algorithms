class Solution(object):
    def superPow(self, a, b):
        """
        :type a: int
        :type b: List[int]
        :rtype: int
        """
        str_rep = "".join(map(str,b))
        return a**int(str_rep) % 1337
