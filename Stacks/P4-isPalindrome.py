def isPalindrome(A):
    i = 0
    j = len(A) - 1
    while ((i<j) and A[i] == A[j]):
        i += 1
        j -= 1
    if(i<j):
        print("Not a palindrome.")
        return 0
    else:
        print("Palindrome.")
        return 1

isPalindrome(['m','a','d','a','m'])
