---
tags: 🌱, TODO
date: 07--Aug--2022
---

# Insertion sort

## Approach

- Given a set of unordered elements, repeatedly remove an entry from the set
- Compare target with each element on the left till the element on the left side is less than target

## Considerations

- Case where N=0 not considered
    - An empty array does not need to be sorted
- Case where N=1
    - A single element in array is already sorted
- Algorithm only considers when N>1

### Code

```java
// Let there be a list of N elements
int list[N];

// Let the first index start from 0
// First element is always sorted, look at the second element
// Check till the last element (N-1)
for (i=1;i<N;i++) {
    // For each current index, check if there is any location
    // to insert the element
    // Satisfaction criteria is when some element greater than current index
    for (j=i;j>0;j--) {
        // Insertion point found
        // Perform swap
        if (list[j-1]>=list[j])
            swap(list[j], list[j-1])
            
        // if there is no swapping done, it means that algorithm is done
        // We always keep the left side of the list sorted
        else break;    
    }
}
```

### Analysis

There is a total of $n-1$ iterations in the outer loop

- Best case = $O(n)$
    - Array is already sorted -> there is only 1 comparison needed in outer loop
    - Total $O(n)$
- Worse case = $O(n^2)$
    - Array is reversed
    - For each loop of length $X$, there needs to be $X-1$ swapping -> $1+2+3+...+N-1 = n( \frac {n-1} {2} )$
    - Overall $O(n^2)$
- Average case = $O(n^2)$
    - TODO
    - Overall $O(n^2)$

---
Links: 