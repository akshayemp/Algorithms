def search(graph,start,end):
    q = LinkedList()
    for node in graph:
        node.state = 'unvisited'
    start.state = 'visiting'
    q.add(start)
    u = Node()
    while !q.isEmpty():
        u = q.pop()
        if u != None:
            for node in u.getAdj():
                if node.state == 'Unvisited':
                    if node == end:
                        return True
                    else:
                        node.state = 'visiting'
                        q.add(node)
        u.state = 'Visited'
    return False
