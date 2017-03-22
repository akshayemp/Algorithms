s = "apple"
abbr = "a31"
def word_abbr(s,abbr):
    i = 0
    while i<len(abbr):
        j = i
        if abbr[i].isdigit():
            x = []
            while abbr[j].isdigit():
                x.append(abbr[j])
                j += 1
            y = int(''.join(x))
            abbr = abbr[:i] + s[i:i+y] + abbr[i+len(x):]
        i += 1
    return abbr == s
        
ans = word_abbr(s,abbr)
print(ans)

