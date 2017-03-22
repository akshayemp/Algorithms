A = [1,2,3,4,5,6,7,8,9,10]
class Node:
    def __init__(self,value):
        self.value = value
        self.right = None
        self.left = None

def create_binary_tree(array):
    if len(array) == 1:
        return array[0]
    mid = len(array)//2
    node = Node(array[mid])
    node.left = create_binary_tree(array[:mid])
    node.right = create_binary_tree(array[mid:])

create_binary_tree(A)
