class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        nums = sorted(nums)
        d = {}
        for x in nums:
            if x not in d:
                d[x] = 1
            else:
                d[x] += 1
        
        for k,v in d.iteritems():
            if v == 1:
                return k
