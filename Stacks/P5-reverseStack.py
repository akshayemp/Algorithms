class Stack:
    def __init__(self):
        self.stack = []

    def push(self,x):
        self.stack.append(x)
        
    def pop(self):
        return self.stack.pop()

    def isEmpty(self):
        return len(self.stack) == 0
    
    def __repr__(self):
        return str(self.stack)
    
## Reverse stack.
def reverseStack(x):
    auxilary_stack = Stack()
    while not x.isEmpty():
        auxilary_stack.push(x.pop())
    print("Reversed stack:",auxilary_stack)

stack = Stack()
stack.push(1)
stack.push(2)
stack.push(3)
stack.push(4)
stack.push(5)
print("Original stack:",stack)
reverseStack(stack)
