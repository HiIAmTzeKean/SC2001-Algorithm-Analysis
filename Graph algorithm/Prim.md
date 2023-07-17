---
tags: 🌱
date: 27--Sep--2022
---

# Prim
Prim is used to create [[Minimum spanning tree]].

## Structure
- Array d
- Array pi
- Array S
- Priority queue q
    - Queue will only hold vertex that are not seen with its corresponding weight
    - Updates to the distance of the unseen vertex is done by decrease key operation
    - q size will be at most O(V)

## Code
```java
public Prim() {
    int[] d;
    int[] pi;
    int[] S;
    PriorityQueue q;
    
    public Prim() {
        for (int i=0; i<g.size; i++){
            d[i] = Integer.MAX_VALUE;
            S[i] = 0;
            pi[i] = -1;
        }
    }
    public void getMST(graph g, int source) {
        d[source] = 0;
        pi[source] = 0;

        // begin the while loop
        // only v-1 edge needs to be found
        while(q.isEmpty()!=true) {
            // pick the shortest edge
            u = q.getMinVertex();
            S[u] = 1;
            updateFringe(q, g, u);
        }
    }
    public void updateFringe(){
        for each w adacent to v {
            // we need to check if w is seen
            // if w is seen do not add the edge as it will cause a cycle
            // if not seen, we add the edge to queue or
            // decrease key depending if vertex is in queue
            if (S[w]!=1) {
                weight = w.getWeight();
                if (d[w]==Integer.MAX_VALUE) {
                    // vertex is not in queue
                    // some new unseen vertex
                    d[w] = weight;
                    q.insert(Node(w,weight));
                }
                else if (weight < d[w]){
                    // vertex is already in queue
                    // w is in fringe as some other vertex has touched it
                    // since we have found a new vertex v which is of shorter
                    // distance to w -> update weight
                    // we need to decrease key here
                    d[w] = weight;
                    q.decreaseKey(Node(w,weight));
                }
            }
        }
    }
}
```

## Time complexity

## Proof of Prim

We need to use the following theorems.

>In a connected weighted graph G = (V, E, W), a tree T is a minimum spanning tree if and only if T has the MST property.
\- Theorem 1

and

> Let G = (V, E, W) be a connected weighted graph; Let Tk be the tree with k vertices constructed by Prim’s Algorithm, for k = 1, 2, …, n; and let Gk be the subgraph induced by the vertices of Tk. Then Tk has the MST property in Gk.
\- Lemma 2

With these two theorems, we can say that

>Prim’s Algorithm outputs a minimum spanning tree.
\- Theorem 2
- Prim algorithm creates trees with MST property
- Since MST property implies MST by theorem 1, Prim outputs MST

---
Links: 