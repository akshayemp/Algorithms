'''
Perform the insertion sort on an array.
'''

def insertion_sort(A):
    for j in range(1,len(A)):
        key = A[j]
        i = j - 1
        while i >= 0 and A[i] > key:
            A[i+1] = A[i]
            i = i - 1
        A[i+1] = key
    return A

print(insertion_sort([5,3,5,1,2,6,3,12]))
