_end = "__end__"

def make_trie(*words):
    root = dict() # root = {}
    for word in words: # for each word 
        current_dict = root # current dictionary
        for letter in word: 
            current_dict = current_dict.setdefault(letter,{})
        current_dict[_end] = _end
    return root


def in_trie(trie,word):
    current_dict = trie
    for letter in word:
        if letter in current_dict:
            current_dict = current_dict[letter]
        else:
            return False
    else:
        if _end in current_dict:
            return True
        else:
            return False

trie = make_trie('foo','bar','baz','barz','fool','cat','catestrophic','catterer')
print(in_trie(trie,'barz'))
print(in_trie(trie,'catte'))
print(in_trie(trie,'cat'))
