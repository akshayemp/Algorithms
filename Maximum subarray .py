'''
    Problem: Given an array find the maximum subarray i.e.
    the greatest subarray which has the greatest sum of any
    contiguous subarray.
'''
import math

A = [13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7]
A_neg = [-6,-3,-5,-7,-1,-10,-6,-8,-2,-9,-4]

def find_max_crossing_subarray(A, low, mid, high):
    max_left = -1
    max_right = -1
    left_sum = float("-infinity")
    s = 0
    
    for i in range(mid+1, low,-1):
        s = s + A[i]
        if s > left_sum:
            left_sum = s
            max_left = i
    right_sum = float("-infinity")
    s = 0
    for j in range(mid+1, high):
        s = s + A[j]
        if s > right_sum:
            right_sum = s
            max_right = j
    return (max_left, max_right, left_sum + right_sum)

def find_maximum_subarray(A, low, high):
    if high == low:
        return (low, high, A[low])
    else:
        mid = math.floor((low + high)/2)
        left_low, left_high, left_sum = find_maximum_subarray(A, low, mid)
        right_low, right_high, right_sum = find_maximum_subarray(A, mid+1,high)
        cross_low, cross_high, cross_sum = find_max_crossing_subarray(A,low,mid,high)

        if left_sum >= right_sum and left_sum >= cross_sum:
            return (left_low, left_high, left_sum)
        elif right_sum >= left_sum and right_sum >= cross_sum:
            return (right_low, right_high,right_sum)
        else:
            return (cross_low, cross_high, cross_sum)

print(find_maximum_subarray(A_neg,0,len(A_neg) - 1))

'''
    #############
    Obervations:
    #############

    1. If all the elements in the array are negative the algorithm returns
       the largest negative number.
    
'''
