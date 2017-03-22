'''
Creating a random number generator.
'''
import time

def Random(a,b):
    if int(time.time()) % 2 == 0:
        return 1
    else:
        return 0

count1 = 0
count0 = 0
for i in range(100000000):
    x = Random(0,1)
    
    if x == 0:
        count0 += 1
    else:
        count1 += 1

print("1s:", count1)
print("0s:",count0)
