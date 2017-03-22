"""
A smart stack that maintains the minimum of the stack.
Takes O(1) time and considerably less space.
"""

class SmartStack:

    def __init__(self):
        self.stack = []
        self.min = []

    def stack_push(self,x):
        self.stack.append(x)
        if not self.min or x <= self.stack_min():
            self.min.append(x)
        
    def stack_pop(self):
        x = self.stack.pop()
        if x == self.stack_min():
            self.min.pop()
        return x

    def stack_min(self):
        return self.min[-1]



smartStack = SmartStack()
smartStack.stack_push(2)
smartStack.stack_push(6)
smartStack.stack_push(4)
print(smartStack.stack_min())
smartStack.stack_push(1)
print(smartStack.stack_min())

