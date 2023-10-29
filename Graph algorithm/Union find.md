---
tags:
  - 🌱
  - ComputerScience 
date: 24--Sep--2022
---

# Union find

Type of implementation to check [[Dynamic equivalence relation]].

## Operations
- find(node)
    - To find which group does node belong to
- connected(node1, node2)
    - To check if node1 and node2 belong to the same group
- union(node1, node2)
    - To connect node1 and node2 such that all elements connected to node1 and all elements connected to node2 form one new group. Where the groupID of node2 will precede.

## Code

```java
public class UnionFind {
    int[] group;
    /**
    * Consutor will take a fixed cost of O(N) that cannot be avoided
    */
    public UnionFind(int size){
        group = new int[size];
        // This operation will loop for N times to set
        // the group ID for each node to itself since each node should only be
        // connect to itself
        for (int i=0; i<size; i++) {
            group[i]=i;
        }
    }
    /**
    * Find operation takes O(1)
    */
    public int find(int node) {
        return group[node];
    }
    /**
    * connected takes O(1) as well
    */
    public boolean connected(int node1, int node2) {
        return find(node1) == find(node2);
    }
    /**
    * Union takes O(N) since we have to iterate through N elements
    * to check if node1 was connected to any other elements and
    * update the groupID accordingly
    */
    public void union(int node1, int node2) {
        int newId = find(node2);
        int idGroupToChange = find(node1);
        for (int i=0; i< group.length; i++) {
            if (group[i] == idGroupToChange) {
                group[i] = newId;
            }
        }
    }
}
```

## Time complexity
- Construction (initialisation)
    - O(N) to set each node to be connected to itself
- find operation
    - O(1)
- connected operation
    - O(1)
- union operation
    - O(N) since there is a need to check each node's groupID
    - If we perform N union operation, we will take $O(N^2)$


---
Links: 