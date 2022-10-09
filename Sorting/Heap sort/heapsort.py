import math
from tempfile import tempdir

def heapSort(heap):
    heapify(heap, 1, len(heap))
    for i in range (len(heap), 0, -1):
        # take root
        maxRoot = heap[0]
        # put leaf at root
        heap[0] = heap[i-1]
        # fix heap
        fix_heap(heap, 1, i)
        heap[i-1] = maxRoot

def heapify_myMethod(heap):
    start = math.ceil(len(heap)/2)
    for i in range(start, 0, -1):
        fix_heap(heap, i)

def heapify(heap, i, N):
    if (2*i>N):
        return
    heapify(heap, 2*i, N)
    heapify(heap, 2*i+1, N)
    fix_heap(heap, i, N)


def fix_heap(heap, i, N):
    
    # check if leaf node
    if (2*i>N):
        return
    # compare left and right
    if (2*i<N and 2*i+1<=N):
        if (heap[2*i-1] > heap[2*i+1-1]): largest = 2*i
        else: largest = 2*i+1
    else:
        largest = 2*i
    # compare root and largest
    if (heap[i-1] < heap[largest-1]):
        # swap
        temp = heap[i-1]
        heap[i-1] = heap[largest-1]
        heap[largest-1] = temp
        fix_heap(heap, largest, N)
        pass
    else:
        # nothing more to fix
        return

if __name__ == "__main__":
    heap = [4,1,2,3,5]
    heapSort(heap)
    print(heap)