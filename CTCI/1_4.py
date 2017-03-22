class threestack:
    def __init__(self,capacity):
        self.capacity = capacity
        self.stack = [None]*self.capacity
        self.top = [0,0,0]
    def push(self,stack,value):
        if self.top[stack] == int(self.capacity/3):
            print("Stack Overflow!")
            return
        self.stack[self.top[stack]+stack*int(self.capacity/3)] = value
        self.top[stack] += 1
    def pop(self,stack):
        if self.top[stack] == 0:
            print("Stack Underflow!")
            return
        self.stack[self.top[stack]+stack*int(self.capacity/3)-1] = None
        self.top[stack] -= 1
    



stack = threestack(10)
stack.push(0,2)
stack.push(1,4)
stack.push(2,3)
stack.push(0,2)
stack.push(1,4)
stack.push(2,3)
stack.push(0,2)
stack.push(1,4)
stack.push(2,3)

print(stack.stack)

stack.pop(0)
stack.pop(1)
stack.pop(2)
print(stack.stack)
