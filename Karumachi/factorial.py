factTable = {}
def factorial(n):
    try:
        return factTable[n]
    except KeyError:
        if n == 0:
            factTable[0] = 1
            return 1
        else:
            factTable[n] = n*factorial(n-1)
            return factTable[n]

print(factorial(10))
