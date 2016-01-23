'''
Bubble sort
'''

def bubble_sort(lst):
    for i in range(len(lst)):
        for j in range(len(lst) - i- 1):
            if lst[j] > lst[j+1]:
                lst[j], lst[j+1] = lst[j+1], lst[j]

lst = [6,8,42,8,35,8,9,12]
print 'Unsorted:', lst

bubble_sort(lst)
print 'Sorted:',lst