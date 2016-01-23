def insertion_sort(lst):

    for i in range(len(lst)):
        j = i
        while j>0 and lst[j]<lst[j-1]:
            lst[j], lst[j-1] = lst[j -1], lst[j]
            j -= 1
lst = [25,15,46,40,17,69,82,29]
print 'Unsorted:', lst

insertion_sort(lst)
print 'Sorted:',lst