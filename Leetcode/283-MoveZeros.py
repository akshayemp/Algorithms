class Solution(object):
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        count = nums.count(0)
        nums[:] = [x for x in nums if x!=0]
        nums.extend([0]*count)
        
        
