class LinkedNOde:
    def __init__(self,value):
        self.value = value
        self.next = None

class linkedlist:
    def __init__(self):
        self.head = None

    def insert(self,value):
        if not self.head:
            self.head = LinkedNode(value)
        insertion_point = head
        while insertion_point.next:
            insertion_point = insertion_point.next
        insertion_point.next = LinkedNode(value)

class Node:
    def __init__(self,value):
        self.value = value
        self.right = None
        self.left = None

    '''def create_linkedlist(self,root):
        if not root:
            return []
        linklist = linkedlist()
        levels = collections.defautdict(linklist) #{1:<>,2:<>,3:<>}
        levels[1].insert(root)
        q = [root]
        while q:
            node = q.pop()'''     
 
    def create_level_linkedlist(root,lists,level):
        if root == None:
            return
        _list = linkedlist()
        if len(lists) == level:
            _list.insert(_list)
        else:
            _list = lists[level]
        _list.insert(root)
        create_level_linkedlist(root.left,{},level+1)
        create_level_linkedlist(root.left,{},level+1)
        
