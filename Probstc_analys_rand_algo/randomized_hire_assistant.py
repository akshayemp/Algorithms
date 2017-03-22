'''
Develop a randomized algorithm to hire an assistant.
'''

# In this senerio a non randomized algorithm may perform
# with worst case as the complexity depends on the input
# if we input an array in such a manner that there will be
# n hiring out of n candidates.
# The best way to perform tht calculations is to randomize
# the algorithm and get an average case scenerio.

import random

def randomized_hire_assistant(A):
    random.shuffle(A)
    best = 0
    for i in range(len(A)):
        if A[i] > best:
            best = A[i]
            print("Hire candidate {}".format(i+1))


randomized_hire_assistant([5,2,1,8,4,7,10,9,3,6])
