def reverse_str(s):
    l = list(s)
    j = len(s)-1
    for i in range(int(len(s)/2)):
        l[i],l[j] = l[j],l[i]
        j -= 1
    print(''.join(l))
            
reverse_str("anaram")
