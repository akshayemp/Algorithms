'''
Merge sort
'''

def merge_sort(list):
    n = len(list)
    if n<=1:
        return list

    left = list[:n/2]
    right = list[n/2:]

    #sort left and right parts
    leftSorted = merge_sort(left)
    rightSorted = merge_sort(right)

    return merge(leftSorted, rightSorted)

def merge(left, right):
    result = []

    while len(left) > 0 and len(right)>0:
        if left[0] < right[0]:
            result.append(left.pop(0))
        else:
            result.append(right.pop(0))

        result.extend(left)
        result.extend(right)

        return result

lst = [37,50,41,31,7,32,49,78]
print 'Unsorted:', lst

merge_sort(lst)
print 'Sorted:',lst

