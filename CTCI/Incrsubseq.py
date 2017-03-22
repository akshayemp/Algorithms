array = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15]

def incrSubseq(array):
    res = [[]]
    ans = []
    for num in array:
        res += [item + [num] for item in res if (item+[num] not in res) and (len(item) == 0 or item[-1]<=num)]
    for values in res:
        if len(values)>1:
            ans = ans + [values]
    print(ans)
incrSubseq(array)
 
