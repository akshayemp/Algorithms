"""
Solve the symbol balancing problem.
"""

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
        if len(self.stack) == 0:
            return True
        else:
            return False
    def top(self):
        return self.stack[-1]    


stack = Stack()
user_input = input()
input_length = len(user_input)

for symbol in user_input:
    input_length -= 1
    # check for left symbols.
    if symbol in ['(','{','[','<']:
        stack.push(symbol)
    # check for right symbols.
    elif symbol in [')','}',']','>']:
        #Check the top of the stack to see if there's a stray symbol, second condition
        # is to avoid checking valid symbol as stray symbol.
        if stack.top() != symbol and stack.top() not in ['(','{','[','<']: # Bug here.
            print("Missing left symbol encountered..exiting.")
            break
        stack.pop()
    # Check if the symbols are balanced.
    if (stack.isEmpty()) and (input_length == 0):
        print("Symbols are balanced.")
        break
    # Check if the symbols are un balances.
    elif (not stack.isEmpty()) and (input_length == 0):
        print("Symbols are not balanced.")
        break

