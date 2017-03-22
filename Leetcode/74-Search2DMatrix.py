class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        lastcol = len(matrix[0]) - 1
        row = 0
        if target == matrix[row][lastcol]:
            return True
        while row < len(matrix):
            if target == matrix[row][lastcol]:
                return True
            if target < matrix[row][lastcol]:
                return self.binarySearch(matrix[row],target)
            else:
                row = row + 1
        return False
    
    def binarySearch(self,array,target):
        begin = 0
        last = len(array) - 1
        mid = (begin + last)//2
        array = sorted(array)
        
        while array[mid] != target:
            if last == 0:
                array = [array[0]]
            else:
                array = array[begin:last]
            mid = (len(array)-1)//2
            if len(array) == 1:
                if array[0] != target:
                    return False
            elif len(array) <= 0:
                return False
            if target > array[mid]:
                begin = mid + 1
            else:
                last = mid - 1
        return True
        
