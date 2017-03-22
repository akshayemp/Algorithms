class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        if len(s) != len(t):
            return False
            
        s = [x for x in s]
        t = [y for y in t]
        s.sort()
        t.sort()
        s = ''.join(s)
        t = ''.join(t)
        if s == t:
            return True
        else:
            return False
