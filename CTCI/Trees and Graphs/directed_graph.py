class graph():
    def __init__(self):
        self.graph = {'A':['B','C'],\
                      'B':['C','D'],\
                      'C':['B'],\
                      'D':['A','E'],\
                      'E':['F']}

    def find_route(self, a,b):
        q = [a]
        while q:
            value = q.pop()
            if value not in self.graph:
                return False
            if value == b:
                return True
            else:
                for neigh in self.graph[value]:
                    q.insert(0,neigh)
        return False

g = graph()
ans = g.find_route('A','F')
print(ans)          
                
        
        

    
    
        
