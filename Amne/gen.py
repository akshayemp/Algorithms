import random

def _gen():
    N = random.randint(1,200000)
    k = random.randint(1,N)
    values = []
    for _ in range(N):
        values.append(str(random.randint(1,1000000)))
    s = " ".join([str(N),str(k)])+"\n"+" ".join(values)
    print(N,k)
    f = open("input.txt","w")
    f.write(s)
    f.close()
    
_gen()
