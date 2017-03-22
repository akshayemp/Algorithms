## Crete stack's data structure.
class Stack():
    def __init__(self):
        self.stack = []

    def push(self,value):
        return self.stack.append(value)

    def pop(self):
        return self.stack.pop()

    def display(self):
        print(self.stack)
        
    def isEmpty(self):
        return len(self.stack) == 0

    def top(self):
        return self.stack[-1]    

def findSpan(A):
    s = [1]*len(A)
    for i in range(0,len(A)):
        j = 1
        while j<= i and A[i] > A[i-j]:
            j = j+1
            s[i] = j
    print(s)

findSpan([6,3,4,5,2])
