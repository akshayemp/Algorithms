'''
    Find the peak in 2D matrix, if all the adjacent
    values of the (i,j) are smaller.
'''

def find_2D_peak(A, low, high):
    mid = (low + high) // 2
    maximum = None
    row = None
    
    for i in range(len(A)):
        if maximum == None:
            maximum = A[i][mid]
        elif A[i][mid] > maximum:
            maximum = A[i][mid]
            row = i
            col = mid

    if  (mid - 1) >= 0 and (mid + 1) < len(A[0]):
        if A[row][mid - 1] > maximum:
            high = mid - 1
            return find_2D_peak(A,low,high)
        elif A[row][mid+1] > maximum:
            low = mid + 1
            return find_2D_peak(A,low,high)
        
    return A[row][mid]

A = [[10,8,10,10],[14,13,12,11],[15,9,11,21],[16,17,19,20]]

result = find_2D_peak(A,0, len(A[0])-1)
print(result)
