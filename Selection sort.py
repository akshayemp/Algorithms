'''
Selection sort
'''

def get_smallest(lst, start):
    '''
    Helper method to find the smallest
    :param lst:
    :param start:
    :return:
    '''

    small = start
    for i in range(start+1, len(lst)):
        if lst[i] < lst[small]:
            small = i
    return small

def selection_sort(lst):
    for i in range(len(lst)):
        smallest = get_smallest(lst, i)

        if smallest !=i:
            lst[smallest], lst[i] = lst[i], lst[smallest]

lst = [38,23,15,28,59,24,40,53]
print 'Unsorted:',lst

selection_sort(lst)
print 'sorted:',lst