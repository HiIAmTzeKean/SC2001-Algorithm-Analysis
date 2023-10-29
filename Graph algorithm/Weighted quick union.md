---
tags:
  - 🌱
  - ComputerScience 
date: 24--Sep--2022
---

# Weighted quick union

Idea is to merge a smaller tree to larger tree → ensure that large trees to not continue to grow in size

## Code
```java
public void union(int u, int v) {
    int i = find(u);
    int j = find(v);
    // if they already have the same root, there is no
    // merging that needs to be done
    if (i==j) return;
    else if (treeSize[i]<treeSize[j]) {
        // i smaller than j
        // j should be the root
        group[i] = j;
        treeSize[j] += treeSize[i];
    }
    else {
        group[j] = i;
        treeSize[i] += treeSize[j];
    }
}
```

## Time complexity
- Depth of tree upper bounded by $O(lg(n))$
    - Depth of tree only increase when some smaller tree is added to a bigger tree
    - When we merge a small tree $T_1$ to a bigger tree $T_2$ we increase depth of $T_1$ by 1
    - We have condition that $T_1$ merge under $T_2$ if $T_1>T_2$ which implies $T_2 = T_1 + c$ for some constant c
    - Then the resulting merged tree will be at least twice the size of $T_1$ where $T = T_2 + T_1 = 2*T_1 +c$
    - We can only double the size of the tree at most $lg_2(n)$ times
- find() operation will take at most $O(lg(n))$
- Since both union and connected uses find, both will also take at most $O(lg(n))$

---
Links: 