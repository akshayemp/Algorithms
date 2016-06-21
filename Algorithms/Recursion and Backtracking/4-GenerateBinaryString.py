def appendAtBeginningFront(x,L):
    """
    Generate all the binary strings with n bits.
    """
    return([x+element for element in L])
    #return(appendAtBeginningFront("0",bitStrings(n-1) + appendAtBeginningFront("1", bitStrings(n-1))))
