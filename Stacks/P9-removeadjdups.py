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

def rmAdjDups(string):
    stack = Stack()
    for symbol in string:
        if stack.top() != symbol:
            stack.push(symbol)
        else:
            stack.pop()
            stack.pop()
    print(stack)


rmAdjDups("mississippi")
