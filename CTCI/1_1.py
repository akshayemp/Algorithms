s = "prei"

def unique(s):
    d = {}
    for v in s:
        if v not in d:
            d[v] = 1
        else:
            return False
    return True
ans = unique(s)
print(ans)
