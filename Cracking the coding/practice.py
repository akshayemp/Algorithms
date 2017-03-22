def unique(s):
    d = {}
    for char in s:
        if char in d:
            return False
        else:
            d[char] = 1
    return True


ans = unique("preit")
print(ans)
