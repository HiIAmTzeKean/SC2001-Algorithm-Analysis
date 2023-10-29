---
tags:
  - 🌱
  - ComputerScience
date: 17--Sep--2022
modified: 22--Oct--2023
---

# Dijkstra

Single-source shortest algorithm.

## Code

``` Java
public void dijkstra (graph g, int source) {
    // initialise the data structures
    /**
    * d stores the distance from a vertex to source node
    * pi stores the direct predecessor of the vertex
    * S is an array to indicate if the vertex has been visited
    */
    int[] d = new int [g.size()];
    int[] pi = new int [g.size()];
    int[] S = new int [g.size()];
    PriorityQueue q = new PriorityQueue();

    // Start with the source vertex
    q.add(source,0);
    while (!q.isEmpty()){
        // pop the shortest vertex from S not yet seen
        Node currentVertex = q.getHead();
        q.removeHead();

        // Mark the current vertex as seen
        S[currentVertex] = 1;
        for (Node adjVertex: g.getAdjacent(currentVertex)) {
            // Check if the adjVertex is already seen
            // if not seen then we check if the distance recorded to the
            // adjacent vertex is shorter if we travel through currentVertex
            if (S[adjVertex]==0 && d[adjVertex]>d[currentVertex]+g.weight(currentVertex,adjVertex)) {
                // Update the distance, predecessor and queue
                d[adjVertex]=d[currentVertex]+g.weight(currentVertex,adjVertex);
                pi[adjVertex] = currentVertex;
                q.decreaseKey(adjVertex,d[adjVertex]);
            }
        }
    }
}
```

## Time complexity
- Worse case is $O(|V^2|)$

## Proof of correctness
- To proof correctness of dijkstra we need to show that by always selecting the next shortest path to travel, we will get the shortest path from source node

![[Pasted image 20220910210346.png]]

## Proof that greedy is optimal


---
Links: 

