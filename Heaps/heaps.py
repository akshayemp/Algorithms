"""
This file contains implementation of heaps
"""

class heap():
    def __init__(self,A):
        self.heap = A

    def parent(self,i):
        return i>>2
    def left(self,i):
        return (i<<1) + 1
    def right(self,i):
        return ((i+1)<<1) 

    def max_heapify(self,i):

        l = self.left(i)
        r = self.right(i)
        if l < len(self.heap) and self.heap[l] > self.heap[i]:
            largest = l
        else:
            largest = i

        if r< len(self.heap) and self.heap[r] > self.heap[largest]:
            largest = r

        if largest != i:
            self.heap[i], self.heap[largest]  = self.heap[largest],self.heap[i]
            self.max_heapify(largest)

heap = heap([16,4,10,14,7,9,3,2,8])
heap.max_heapify(1)
print(heap.heap)
