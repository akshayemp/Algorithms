"""
Filtering list
"""

sample_list = [25, 'Huzaifah', 38, 'adnan', 54, 'mani']

def filter_marks(lst):
    '''
    filters integers from list
    :param lst:
    :return:
    '''

    integers = []
    rest = []

    for ele in lst:
        if type(ele) is int:
            integers.append(ele)
        else:
            rest.append(ele)
    return integers, rest

integers, rest = filter_marks(sample_list)

print 'Integers: ', ',' .join([str(x) for x in integers])
print 'Others: ', ','.join(rest)