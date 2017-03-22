'''
    
Problem: Multiply two matrices.

'''
import numpy as np

def square_matrix_multiplication(A,B):
    '''
    This algorithm takes O(n^3) time.
    '''
    n = len(A) # no. of rows
    c = [[0 for _ in range(n)] for _ in range(n)]
    for i in range(n):
        for j in range(n):
            for k in range(n):
                c[i][j] += A[i][k] * B[k][j]
    return c


print(square_matrix_multiplication([[1,0],[0,1]], [[3,4],[1,2]]))


'''
Does recursive algorithm helps?
'''

def square_matrix_multiplication_recursive(A,B):
    n = len(A)
    c = [[0 for _ in range(n)] for _ in range(n)]
    if n == 1:
        c[0][0] = A[0][0] * B[0][0]
    else:
        A11,A12,A21,A22 = partition(A)
        B11,B12,B21,B22 = partition(B)

        # These are concatinating.

        c[0][0] = np.array((square_matrix_multiplication_recursive(A11,B11))) + np.array((square_matrix_multiplication_recursive(A12,B21)))
        c[0][1] = np.array((square_matrix_multiplication_recursive(A11,B12))) + np.array((square_matrix_multiplication_recursive(A12,B22)))
        c[1][0] = np.array((square_matrix_multiplication_recursive(A21,B11))) + np.array((square_matrix_multiplication_recursive(A22,B21)))
        c[1][1] = np.array((square_matrix_multiplication_recursive(A21,B12))) + np.array((square_matrix_multiplication_recursive(A22,B22)))
    return np.concatenate(list(np.dstack(c).T))

def partition(m):
    mid = len(m)//2
    m1,m2,m3,m4 = [],[],[],[]
    for i in range(mid):
        m1.extend([m[i][0:mid]])
        m2.extend([m[i][mid:]])
    for i in range(mid,len(m)):
        m3.extend([m[i][0:mid]])
        m4.extend([m[i][mid:]])
    return m1,m2,m3,m4
        
        
print(square_matrix_multiplication_recursive([[1,0],[0,1]], [[3,4],[1,2]]))
