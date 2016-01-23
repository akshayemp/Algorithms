'''
Binary search
'''

def binary_search(lst, target):
    i=0
    j = len(lst) - 1

    while i<j:
        m = (i + j) / 2
        if lst[m] < target:
            i = m+1
        else:
            j=m
    if lst[i] == target:
        return i
    else:
        return -1

lst = range(0,50,5)

index = binary_search(lst,10)
print 'Found 10 at: ', index