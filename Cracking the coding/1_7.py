def setZeros(A):
    row = [0]*len(A)
    col = [0]*len(A)
    for i in range(len(A)):
        for j in range(len(A[0])):
            if A[i][j] == 0:
                row[i] = 1
                col[j] = 1
    for i in range(len(A)):
        for j in range(len(A[0])):
            if ((row[i] == 1) | (col[j] == 1)):
                A[i][j] = 0
    return A

M = [[1,2,3],[2,0,1],[1,1,1],[0,1,1]]
ans = setZeros(M)
print(ans)
