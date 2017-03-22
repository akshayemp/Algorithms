class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        for i,v in enumerate(nums):
            x = target - nums[i]
            if (x in nums) and (i!=nums.index(x)):
                return [i,nums.index(x)]
        
