
from numpy import sort

def knapsackBottomUp(C,p,w,W):
    # init array of W * C
    arr = [[0 for i in range(1+W)] for j in range(1+C)]
    for i in range(1,C+1):
        for index in range(W):
            j = index + 1
            
            notTaken=taken=takenReplacement=0
            # If not taken
            notTaken = arr[i][j-1]
            
            if (i>=w[index]):
                # If taken and do not consider repeat
                taken = arr[i-w[index]][j-1] + p[index]
                # If taken and consider repeat
                takenReplacement = arr[i-w[index]][j] + p[index]

            arr[i][j] = max(notTaken,taken,takenReplacement)
    printArray(arr)
    return arr[C][W]

def knapsackBottomUpSimple(C,p,w,W):
    arr = [[0 for i in range(1+W)] for j in range(1+C)]
    for i in range(1,C+1):
        for index in range(W):
            j = index + 1
            arr[i][j] = max(arr[i][j-1],
                            arr[i-w[index]][j-1] + p[index] if i>=w[index] else 0,
                            arr[i-w[index]][j] + p[index] if i>=w[index] else 0)
    return arr[C][W]

def knapsackBottomUpSpaceOptimise(C,p,w,W):
    w = sort(w)
    wMin = min(w)
    # C - min(w) = number of rows needed
    # all rows below min(w) will always be 0
    # Init 1st row to be 0s and 1st col to be 0 as base case
    arr = [[0 for i in range(1+W)] for j in range(1+C-wMin+1)]
    for capacity in range(wMin,C+1):
        # Use i as indexing for array
        i = capacity - wMin + 1
        for index in range(W):
            # Use j as indexing for array
            j = index + 1
            
            notTaken=taken=takenReplacement=0
            # If not taken
            notTaken = arr[i][j-1]
            
            if (capacity>=w[index]):
                # If taken and do not consider repeat
                taken = (arr[i-w[index]][j-1] if capacity-w[index]>=wMin else 0) + p[index]
                # If taken and consider repeat
                takenReplacement = (arr[i-w[index]][j] if capacity-w[index]>=wMin else 0) + p[index]

            arr[i][j] = max(notTaken,taken,takenReplacement)
    return arr[C-wMin][W]

def printArray(arr):
    for i in arr:
        for j in i:
            print(j, end="\t")
        print()
    print()
    
    
if __name__ == "__main__":
    # p = [7,6,9]
    # w = [4,6,8]
    p = [7,6,9]
    w = [5,6,8]
    print("Result: "+ str(knapsackBottomUpSpaceOptimise(14,p,w,3)))