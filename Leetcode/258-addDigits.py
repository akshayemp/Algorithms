class Solution(object):
    def addDigits(self, num):
        """
        :type num: int
        :rtype: int
        """
        while len(str(num)) != 1:
            str_num = str(num)
            num = sum([int(i) for i in str_num])
        return num
