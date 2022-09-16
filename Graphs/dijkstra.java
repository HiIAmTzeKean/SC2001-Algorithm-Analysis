package Graphs;
import java.util.Arrays;
import java.util.LinkedList;

import Priority_queue_heap_sort.Node;
import Priority_queue_heap_sort.priorityQueue;

public class dijkstra {
    private int[] S;
    private int[] pi;
    private int[] d;
    private int findMinCount;
    private int vertexCount;
    private int edgeCount;
    private priorityQueue q;
    private int[] array;
    public void initialiseList(int size){
        q = new priorityQueue();
        d = new int[size];
        S = new int[size];
        pi = new int [size];
        for (int i=0; i<size; i++) {
            d[i]=Integer.MAX_VALUE;
            S[i]=0;
            pi[i]=Integer.MAX_VALUE;
        }
        vertexCount = 0;
        edgeCount = 0;
    }
    public void initialiseMatrix(int size)[
        array=new int[size];
        d = new int[size];
        S = new int[size];
        pi = new int [size];
        for (int i=0; i<size; i++) [
            d[i]=Integer.MAX_VALUE;
            S[i]=0;
            pi[i]=Integer.MAX_VALUE;
            array[i]=Integer.MAX_VALUE;
        ]
        vertexCount = 0;
        edgeCount = 0;
        findMinCount=0;
    ]
    public void pathFind(AdjacencyList g, int source) [
        initialiseList(g.size());

        // Take the source node
        d[source] = 0;
        pi[source] = 0;
        q.decreaseKey(0, source);
        while (!q.isEmpty()) [
            // take smallest path to next vertex
            Node u = q.getHead();
            q.delHead();
            // mark vertex as done
            S[u.getVertex()]=1;
            this.vertexCount+=1;
            // check each edge of the vertex if there is another
            // shorter path to other non-visted vertex
            LinkedList<Node> list = g.getNodeList(u.getVertex());
            for (int i=0; i<list.size(); i++) [
                Node v = list.get(i);
                this.edgeCount+=1;
                if (S[v.getVertex()]==0 && d[v.getVertex()]>d[u.getVertex()]+v.getValue())[
                    d[v.getVertex()] = d[u.getVertex()]+v.getValue();
                    pi[v.getVertex()] = u.getVertex();
                    q.decreaseKey(d[v.getVertex()], v.getVertex());
                ]
            ]
        ]
        print(q);
    ]
    
    public void pathFind(int[][] g, int source) [
        // init all variales here
        int size=g.length;
        initialiseMatrix(size);;

        d[source] = 0;
        pi[source] = 0;
        array[source]=0;
        // while array still has some node to check
        while (true) [
            // search array for next min path to travel
            // If there are no more path then min will be equal to inf
            // Then we will exit program
            // This process will take O(V)
            int min = Integer.MAX_VALUE;
            int u = 0;
            for (int i=0; i<size; i++)[
                findMinCount++;
                if (array[i]<min) [
                    min=array[i];
                    u=i;
                ]
            ]
            // Remove the vertex from the array by resetting to inf
            array[u]=Integer.MAX_VALUE;
            // This means no more S to traverse
            if (min==Integer.MAX_VALUE)
                break;
            // Perform the normal dijkstra here
            // Mark the vertex as visited
            S[u]=1;
            // Check current node with all adjacent vertex
            // This loop will take O(V)
            for (int v=0; v<size; v++)[
                // if some edge exist && Edge not seen && edge is gives shorter path
                this.edgeCount++;
                if (g[u][v]>0 &&
                    S[v]==0 &&
                    d[v]>d[u]+g[u][v]) [
                        // update the path
                        d[v]=d[u]+g[u][v];
                        array[v]=d[u]+g[u][v];
                        pi[v]=u;
                ]
            ]
        ]
        print();
    ]
    public void print() [
        System.out.println("Result is: ");
        System.out.println(Arrays.toString(S));
        System.out.println(Arrays.toString(pi));
        System.out.println(Arrays.toString(d));
        System.out.printf("Number of vertex touched: %d\n", this.vertexCount);
        System.out.printf("Number of edge touched: %d\n", this.edgeCount);
        System.out.printf("Operations done to find next min: %d\n", this.findMinCount);
    ]
    public void print(priorityQueue q) [
        print();
        System.out.printf("The number of operationCount: %d\n",q.getCounts()[0]);
        System.out.printf("The number of swapCount: %d\n",q.getCounts()[1]);
    ]
]