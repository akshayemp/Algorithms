class Solution(object):
    def titleToNumber(self, s):
        """
        :type s: str
        :rtype: int
        """
        def returnAscii_norm(s):
            s = s.strip()
            ascii_s = ord(s)
            norm_s = ascii_s - 65
            return norm_s 
        
        s_array = [x for x in s]
        s_array_len = len(s_array)
        summed_values = 0
            
        for each in s_array:
            s_array_len -= 1
            summed_values += (returnAscii_norm(each) + 1) * 26**(s_array_len)
        return summed_values
                
            
