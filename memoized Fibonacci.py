'''
Memoized fibonacci
'''

memoTable = {}

def memoizedFibonacci(n):
    if n<=2: return 1

    if n in memoTable:
        return memoTable[n]

    memoTable[n] = memoizedFibonacci(n-1) + \
                    memoizedFibonacci(n-2)
    return memoTable[n]

print memoizedFibonacci(10)