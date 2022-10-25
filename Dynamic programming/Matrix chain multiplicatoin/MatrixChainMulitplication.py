# A naive recursive implementation that
# simply follows the above optimal
# substructure property
import sys
 
# Matrix A[i] has dimension p[i-1] x p[i]
# for i = 1..n
def MatrixChainOrder(p, i, j):
 
    if i == j:
        return 0
 
    cost = sys.maxsize
     
    for k in range(i, j):
     
        c = (MatrixChainOrder(p, i, k)
            + MatrixChainOrder(p, k + 1, j)
            + p[i-1] * p[k] * p[j])
 
        if c < cost:
            cost = c;
     
 
    # Return minimum count
    return cost;
 
 
# Driver program to test above function
arr = [1, 2, 3, 4, 3];
n = len(arr);
 
print("Minimum number of multiplications is ",
                MatrixChainOrder(arr, 1, n-1));
 
# This code is contributed by Aryan Garg