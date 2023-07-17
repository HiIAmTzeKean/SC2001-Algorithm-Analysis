---
tags: 🌱
date: 27--Sep--2022
---

# Kruskal

## Strategy

- We sort the edges in a priority queue and we repeatedly pick edges till we have v-1 edges that connect v vertex
- While processing an edge, we must check if edge creates a cycle, if it does, we discard the edge
    - We can check if there is a cycle either by doing a DFS which takes O(V)
    - or [[Weighted quick union path compression]] taking $O(log^*V)$

## Code
```java
public class Kruskal{
    public void findMST() {
        // insert all edges into priority queue
        // which takes O(E)
        PriorityQueue p = new PriorityQueue(g.edges());
        // initialise union find structure
        // take O(V)
        UnionFind uf = new UnionFind(g.vertex());
        
        // for each edge we take out and del from priority queue -> O(lgE)
        // check if connected -> O(log^*V)
        // if not connected then we add it into MST -> O(1)
        // and we connect the 2 vertex -> O(log^*V)
        // connecting 2 vertex will only be done at most O(V-1)
        // times since we will only find V-1 suitable edges
        //
        // We perform this loop till we have v-1 edge, worst case
        // we iterate through all the edges O(E)
        // For an undirected graph that is strongly connected, we have
        // E>V so we can sub all V for E when finding upper bound
        while (mst.size()!=g.vertexCount()-1 && !q.isEmpty()) {
            Edge u = q.getHead(); //get and del head
            int v = u.left();
            int w = u.right();
            if (!uf.connected(v,w)){
                // not connected implies no cycle
                uf.union(v,w);
                mst.add(u);
            }
        }
    }
}
```

## Time complexity
- $O(E * lg(E))$
## Proof
Proof by contradiction used
Suppose that tree T produced by Kruskal is not MST → does not satisfy MST property. Then there must be some edge u-v that is not in T such that addition of u-v creates a cycle where another edge x-y has weight greater than u-v
$$weight(x-y)>weight(u-v)$$
But if weight(x-y) is greater than weight(u-v) then x-y will be processed after u-v in [[Kruskal]]. So when u-v is processed, addition of u-v does not create a cycle, and this contradicts that u-v is not in T.


---
Links: 