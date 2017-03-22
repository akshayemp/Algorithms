def remDups(s):
    if s == None:
        return []
    if len(s)<2:
        return s
    lst = []
    for v in s:
        if v not in lst:
            lst.append(v)
    return "".join(lst)
print(remDups("ababab"))
    
