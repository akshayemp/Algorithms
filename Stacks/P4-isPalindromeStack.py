'''
Checking palindrome using a stack. (Not optimized..more or like not happy
with this implimentation.)
'''
def isPalindrome(A):
    stack = []
    it = iter(A)
    for symbol in A:
        idx = int(len(A)/2)
        if symbol == A[idx]:
            while len(stack) != 0:
                idx = idx + 1
                if stack.pop() == A[idx]:
                    continue
                else:
                    print("Not a palindrome.")
                    return
        else:
            stack.append(symbol)
    print("Is palindrome.")
                

isPalindrome("maXssam")
        
