'''
Linear Search Algorithm
'''

def linear_search(container, ele):
    for i in range(len(container)):
        if container[i] == ele:
            return i
    return -1

lst = [1,2,7,3,9,2,4,6]

index = linear_search(lst,7)
print 'Found 7 at index', index