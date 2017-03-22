array = [0,0,0,1,1]


stack = []
res = []
for i in range(len(array)):
    if (array[i] == 1):
        stack.append(i)

print(stack)
