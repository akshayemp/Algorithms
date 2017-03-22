'''
Sorting an array using Merge Sort
'''

def merge_sort(A):
    if len(A) == 1:
        return A
    mid = len(A) // 2
    left_array = A[:mid]
    right_array = A[mid:]
    left_sorted = merge_sort(left_array)
    right_sorted = merge_sort(right_array)
    merged = merge(left_sorted, right_sorted)
    return merged
    
def merge(l,r):
    merge_list = []
    i,j = 0,0
    while i < len(l) and j  < len(r):
        if l[i] < r[j]:
            merge_list.append(l[i])
            i += 1
        else:
            merge_list.append(r[j])
            j += 1
    if j < len(r):
        merge_list.extend(r[j:])
    if i < len(l):
        merge_list.extend(l[i:])
    return merge_list

A = [3,5,2,6,1,0,0,34,9,12,3,92,23,5,9,-1]
print(merge_sort(A))
