inp = "4-2;BEGIN-3;3-4;2-3"
d = {}
x = inp.split(';')

for v in x:
    j = v.split('-')
    d[j[0]] = j[1]

k = d['BEGIN']
c = 1
flag = True
while ((k != 'END')):
    k = d[k]
    c += 1
    if c > len(d):
        print("BAD")
        flag = False
        break
if flag:
    if c == len(d):
        print("GOOD")
    else:
        print("BAD")


