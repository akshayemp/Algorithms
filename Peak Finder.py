'''
    Find a peak in an array if it exists.
    e.g. : b is a peak if b >= a and b >= c
    A = [a,b,c,d,e,f,g,h,i]    
'''
A = [5,2,2,4,3]

def find_peak(A,low,high):
    mid = int((low + high) / 2)
    if A[mid] < A[mid-1]:
        return find_peak(A,low,mid-1)
    elif A[mid] < A[mid + 1]:
        return find_peak(A,mid+1, high)
    else:
        return A[mid]

print(find_peak(A,0,len(A)-1))
