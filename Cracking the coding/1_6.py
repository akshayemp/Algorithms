def rotate_image(A):
    #1000       0001
    #0100       0010
    #0010       0100
    #0001       1000
    N = len(A[0])
    index = []
    for idx,_ in enumerate(A):
        index.append(idx)
    swap(index)
    X = []
    for v in index:
        X.append(A[v])
    return X

def swap(l):
    j = len(l) - 1
    for i in range(int(len(l)/2)):
        l[i],l[j] = l[j],l[i]
        j -= 1
    return l

ans = rotate_image([[1,0,0,0],
              [0,1,0,0],
              [0,0,1,0],
              [0,0,0,1]])


print(ans)
