---
tags: 🌱
date: 27--Sep--2022
---

# Weighted quick union path compression

Implementation similar to [[Weighted quick union]] but we apply path compression during a find operation to reduce cost of find

## Code
```java
public int find(int v) {
    while (v!=group[v]) {
        // perform path compression here
        // we set the current node to point to its grandparent
        // Hence reducing depth of current node by 2
        group[v] = group[group[v]];
        v = group[v];
     }
}
/**
* Here we set each node we touch to the root
* This is also known as a two-pass implementation
*/
public int findRecursive(int v){
    if (v!=group[v])
        return group[v]=findRecursive(group[v]);
    return group[v];
}
```

## Time complexity
- Initialisation takes O(n)
    - Fixed cost since we need to create the arrays
- All other operations bounded by $O(M*log^*N)$
    - where $log^*N = 1 + log^*(log(N))$

---
Links: 