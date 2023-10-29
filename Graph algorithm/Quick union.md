---
tags:
  - 🌱
  - ComputerScience 
date: 24--Sep--2022
---

# Quick union

Enhanced [[Union find]] -> lazy approach to finding union. Makes use of the notion of a *parent* to check if nodes are connected.

Nodes that are connected to each other will share a root node, and to find if nodes are connected, we check if they share the same root. This is possible because when connecting nodes to the root, we form a [[Tree structure]] where there will **no cycles** -> repeated call of $group[group[group[...group[i]]]]$ will not be infinite.

## Operations
- find(node)
    - To recursively find the root of the current node
- connected(node1, node2)
    - To check if node1 and node2 have the same root node
- union(node1, node2)
    - To connect root of node1 to become the child of the root of node2

## Code
```java
public class QuickUnion {
    int[] group;
    public QuickUnion(int size) {
    
    }
    /**
    * We can implement 2 different types of find
    * a recursive find or an interative one
    */
    public int find(int node) {
        if (group[node] == node) return node;
        return find(group[node]);
    }
    public int find2(int node) {
        while (group[node] != node) node=group[node];
        return node;
    }
    public boolean connected(int node1, int node2) {
        return find(node1) == find(node2);
    }
    public void union(int node1, int node2) {
        // set the root of node1 to point to root of node2
        rootNode2 = find(node2);
        rootNode1 = find(node1);
        group[rootNode1] = rootNode2;
    }
}
```

## Time complexity
- Construction
    - O(N) is still fixed
- find
    - O(N) worse case if nodes are connected such they form a linear chain
    - Then the height of the tree will be N
- connected
    - Since find takes O(N) worse case, and we call find twice, this method will take at most O(2N) = O(N)
- union
    - find takes O(N) and we call find twice here -> O(2N)
    - Changing the root node of node1 takes O(1)
    - Overall O(N)
---
Links: 