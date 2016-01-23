'''
Factorial
'''

def factorial(n):
    if n<=1:
        return 1
    else:
        return n* factorial(n-1)

fact6 = factorial(6)
print 'factorial of 6 is', fact6