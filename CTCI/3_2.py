class stack:
    def __init__(self):
        self.stack = []
        self.min =  [float('inf')]
        self.top = 0
    def push(self,value):
        self.stack.append(value)
        if value < self.min[self.top]:
            self.min.append(value)
            self.top += 1
        else:
            self.min.append(self.min[-1])

    def pop(self):
        self.stack.pop()
        self.min.pop()

    def min_stack(self):
        print(self.min)
        
        
s = stack()
s.push(1)
s.min_stack()
s.push(2)
s.min_stack()
s.push(3)
s.min_stack()
s.push(4)
s.min_stack()
s.push(0)
s.min_stack()
s.push(1)

s.min_stack()

s.pop()

s.min_stack()
