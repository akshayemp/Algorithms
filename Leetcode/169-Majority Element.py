class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        unique_nums = set(nums)
        z = {k:nums.count(k) for k in unique_nums}
        for k,v in z.items():
            if v>len(nums)/2:
                return k
