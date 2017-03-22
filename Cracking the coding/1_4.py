def anagrams(s,t):
    return sorted(s) == sorted(t)

ans = anagrams("water","reawt")
print(ans)
