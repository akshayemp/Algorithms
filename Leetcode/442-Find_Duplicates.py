class Solution(object):
    def findDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        count_dict = {}
        for value in nums:
            if value in count_dict:
                count_dict[value] += 1
            else:
                count_dict[value] = 1
        answer = []
        for key,value in count_dict.iteritems():
            if value == 2:
                answer.append(key)
        return answer
