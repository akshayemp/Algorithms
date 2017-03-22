class Vertex:
    def __init__(self,value):
        self.value = value
        self.color = None
        self.d = None
        self.pi = None
        
    def __hash__(self):
        return hash(self.value)

class Graph:
    def __init__(self):
        self.vertex = set([])
        self.edges = {}
        
    def insertVertex(self,value):
        self.vertex.add(value)

    def addEdges(self,vertex_one,vertex_two):
        if vertex_one.value in self.edges:
            self.edges[vertex_one.value].append(vertex_two)
        else:
            self.edges[vertex_one.value] = [vertex_two]

        if vertex_two.value in self.edges:
            self.edges[vertex_two.value].append(vertex_one)
        else:
            self.edges[vertex_two.value] = [vertex_one]
    
    
    def bfs(self,G,source):
        for u in self.vertex - set([source]):
            u.color = 'white'
            u.d = float('inf')
            u.pi = None
        source.color = 'gray'
        source.d = 0
        source.pi = None
        Q = []
        Q.insert(0,source)
        while Q:
            u = Q.pop()
            for v in G.edges[u.value]:
                if v.color == 'white':
                    v.color = 'gray'
                    v.d = u.d + 1
                    v.pi = u
                    Q.insert(0,v)
            u.color = 'black'
            print(u.value)
            
        


graph = Graph()
v1 = Vertex(1)
v2 = Vertex(2)
v3 = Vertex(3)
v4 = Vertex(4)
v5 = Vertex(5)

graph.insertVertex(v1)
graph.insertVertex(v2)
graph.insertVertex(v4)
graph.insertVertex(v3)
graph.insertVertex(v5)

graph.addEdges(v1,v2)
graph.addEdges(v1,v5)
graph.addEdges(v5,v2)
graph.addEdges(v5,v4)
graph.addEdges(v2,v4)
graph.addEdges(v4,v3)
graph.addEdges(v2,v3)

graph.bfs(graph,v1)


