"""
Convert infix notation to postfix.
"""

## Crete stack's data structure.
class Stack():
    def __init__(self):
        self.stack = []
        
    def __repr__(self):
        return "|".join(self.stack)
    def push(self,value):
        return self.stack.append(value)

    def pop(self):
        return self.stack.pop()

    def display(self):
        print(self.stack)
        
    def isEmpty(self):
        if len(self.stack) == 0:
            return True
        else:
            return False
    def top(self):
        return self.stack[-1]    

user_input = input()
def infix_to_postfix(user_input):
    prec = {'*':3,'/':3,'+':2,'-':2,'(':1}
    stack = Stack()
    tokens = user_input
    for token in tokens:
        if token.isalnum():
            print(token,end='')
        if token in ['*','/','+','-','(',')']:
            if ((token in prec.keys()) or (token == '(')):
                if (not stack.isEmpty()):
                    if prec[token] <= prec[stack.top()] and (token not in ['(',')']):
                        print(stack.pop(),end='')
                        stack.push(token)
                    else:
                        stack.push(token)
                else:
                    stack.push(token)
            elif token is ')':
                while (stack.top() != '(') or (stack.isEmpty()):
                    print(stack.pop(),end='')
                stack.pop()
                
    while not stack.isEmpty():
        print(stack.pop(),end='')

infix_to_postfix(user_input)
