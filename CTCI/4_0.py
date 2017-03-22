# This is what a graph is..
graph = {"a":["c"],
         "b":["c","e","f"],
         "c":["a","b","c","d"],
         "d":["c"],
         "e":["c","b"],
         "f":["b"]
         }


def generate_edges(graph):
    edges = []
    for node in graph:
        for neighbour in graph[node]:
            edges.append((node,neighbour))
    return edges

#print(generate_edges(graph))

def find_isolated_nodes(graph):
    isolated = []
    for node in graph:
        if not graph[node]:
            isolated += node
    return isolated

#print(find_isolated_nodes(graph))

def find_path(start_vertex,end_vertex,path = None):
    if path == None:
        path = []
    path.append(start_vertex)
    if start_vertex == end_vertex:
        return path
    if start_vertex not in graph:
        return None
    for vertex in graph[start_vertex]:
        if vertex not in path:
            extended_path = find_path(vertex,end_vertex,path)
            if extended_path:
                return extended_path
    return None

#print(find_path("a","e"))

def dfs(graph,start_vertex):
    visited,stack = [],[start_vertex]
    while stack:
        vertex = stack.pop()
        if vertex not in visited:
            visited.append(vertex)
            stack.extend([x for x in graph[vertex] if x not in visited])
    return visited
            
def bfs(graph,start_vertex):
    visited,q = [],[start_vertex]
    while q:
        vertex = q.pop()
        if vertex not in visited:
            visited.append(vertex)
            for v in graph[vertex]:
                if v not in visited:
                    q.insert(0,v)
    return visited
print(bfs(graph,"a"))
        
