## This is an implementation of
## Stack ADT using array.

class Stack(object):

    # Constructor for stack.
    def __init__(self,size):
        self.size = size
        self.stack = []

    # Insert values into the stack.    
    def push(self,item):
        if len(self.stack) >= self.size:
            print("Stack Overflow")
        else:
            self.stack.append(item)
        print("Stack is ", self.stack)

    # Delete the top element from the stack.    
    def pop(self):
        if len(self.stack) <= 0:
            print("Stack Underflow")
        else:
            self.stack.pop()
        print("Stack is ", self.stack)

    # Check the top element of the stack.
    def peek(self):
        if len(self.stack)<= 0:
            print("Stack Underflow")
        else:
            return self.stack[-1]

    # Check if the stack is empty or not.
    def isEmpty(self):
        return len(self.stack)<=0

    # Get the size of the array.
    def length(self):
        return len(self.stack)

def testStack():
    stack = Stack(10)
    stack.push(1)
    stack.push(2)
    stack.push(30)
    stack.pop()
    stack.pop()
    print(stack.peek())
    stack.push(20)
    print(stack.isEmpty())
    print(stack.length())
    

testStack()
