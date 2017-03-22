class Node:
    def __init__(self,label=None,data=None):
        self.label = label
        self.data = data
        self.children = dict()

    def addChild(self,key,data=None):
        if not isinstance(key,Node):
            self.children[key] = Node(key,data)
        else:
            self.children[key.label] = key

    def __getitem__(self,key):
        return self.children[key]


class Trie:
    def __init__(self):
        self.head = Node()

    def __getitem__(self,key):
        return self.head.children[key]

    def add(self,word):
        current_node = self.head
        word_finished = True

        for i in range(len(word)):
            if word[i] in current_node.children:
                current_node = current_node.children[word[i]]
            else:
                word_finished = False
                break

        # For ever new letter, create a new child node.
        if not word_finished:
            while i<len(word):
                current_node.addChild(word[i])
                current_node = current_node.children[word[i]]
                i += 1
        current_node.data = word

    def has_word(self,word):
        if word == '':
            return False
        if word == None:
            raise ValueError('Trie.has_word requires a not-Null string')

        current_node = self.head
        exists = True
        for letter in word:
            if letter in current_node.children:
                current_node = current_node.children[letter]
            else:
                exists = False
                break
        if exists:
            if current_node.data == None:
                exists = False
        return exists
        
