def isRotation(s,t):
    if ((len(s) == len(t)) & (len(s) > 0)):
        x_s = s+t
        if s in x_s:
            return True
    return False
ans = isRotation("waterbottle","erbttlewat")
print(ans)
