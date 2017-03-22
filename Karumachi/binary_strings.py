def binary_string(n,idx,result = []):
    if idx > n:
        return result
    s = [1]*idx + [0] * (n-idx)
    print("s=",s)
    for i in range(len(s)-1,idx-1,-1):
        sn = s
        sn[i] = 1
        print("idx=",idx,"s=",s)
        result.append(sn[i])
    return binary_string(len(s)-1,idx+1)

ans = binary_string(4,0)
print(ans)
