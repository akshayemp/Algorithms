def ins_sort(A,i):
    if i == 0: return
    ins_sort(A,i-1)
    j = i
    while j>0 and A[j-1] > A[j]:
        print(A)
        A[j-1],A[j] = A[j],A[j-1]
        j -= 1
        

A = [2,1,2,9,4,6,3]
ins_sort(A,len(A)-1)
print(A)
