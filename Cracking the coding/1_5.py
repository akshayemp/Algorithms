def replace_space(s):
    list_string = list(s)
    for idx,v in enumerate(list_string):
        if v == ' ':
            list_string[idx] = '%20'
            
    return ''.join(list_string)

ans = replace_space("Ezio Auditore de ferenze")
print(ans)

def replace_space2(s):
    return s.replace(" ","%20")

ans = replace_space2("Ezio Auditore de ferenze")
print(ans)
