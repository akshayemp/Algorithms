class Solution(object):
    def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        """
        dictionary = {'I':1,'V':5,'X':10,'L':50,'C':100,'D':500,'M':1000}
        total = 0
        s_list = list(s)
        for idx in range(len(s_list)):
            if idx > 0:
                if dictionary[s_list[idx]] > dictionary[s_list[idx-1]]:
                    total += dictionary[s_list[idx]] - 2 * dictionary[s_list[idx-1]] # Because we added it once already. subtract two times.
                elif s_list[idx] in dictionary:
                    total += dictionary[s_list[idx]]
            else:
                total += dictionary[s_list[idx]]
        return total
        
