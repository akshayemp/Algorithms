class Solution(object):
    def containsDuplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        if len(nums) == 0:
            return False
        nums.sort()
        for i in range(0,len(nums)-1):
            if nums[i+1] == nums[i]:
                return True
        return False
                
