package Graphs;

import java.util.Arrays;
import java.util.LinkedList;

import Node.Node;
import Priority_queue_heap.priorityQueue;
import Priority_queue_array.priorityQueue;

public class Dijkstra {
    private int[] S;
    private int[] pi;
    private int[] d;
    private int vertexCount;
    private int edgeCount;
    private Priority_queue_heap.priorityQueue q;
    private Priority_queue_array.priorityQueue a;

    public void initialiseList(int size) {
        q = new Priority_queue_heap.priorityQueue();
        d = new int[size];
        S = new int[size];
        pi = new int[size];
        for (int i = 0; i < size; i++) {
            d[i] = Integer.MAX_VALUE;
            S[i] = 0;
            pi[i] = Integer.MAX_VALUE;
        }
        vertexCount = 0;
        edgeCount = 0;
    }
    public void pathFind(AdjacencyList g, int source, boolean isSimple) {
        initialiseList(g.size());

        // Take the source node
        d[source] = 0;
        pi[source] = 0;
        q.decreaseKey(0, source);
        while (!q.isEmpty()) {
            // take smallest path to next vertex
            Node u = q.getHead();
            q.delHead();
            // mark vertex as done
            S[u.getVertex()] = 1;
            this.vertexCount += 1;
            // check each edge of the vertex if there is another
            // shorter path to other non-visted vertex
            LinkedList<Node> list = g.getNodeList(u.getVertex());
            for (int i = 0; i < list.size(); i++) {
                Node v = list.get(i);
                this.edgeCount += 1;
                if (S[v.getVertex()] == 0 && d[v.getVertex()] > d[u.getVertex()] + v.getValue()) {
                    d[v.getVertex()] = d[u.getVertex()] + v.getValue();
                    pi[v.getVertex()] = u.getVertex();
                    q.decreaseKey(d[v.getVertex()], v.getVertex());
                }
            }
        }
        print(true,isSimple);
    }
    public void pathFind(int[][] g, int source, boolean isSimple) {
        // init all variales here
        int size = g.length;
        a = new Priority_queue_array.priorityQueue(size);
        d = new int[size];
        S = new int[size];
        pi = new int[size];
        for (int i = 0; i < size; i++) {
            d[i] = Integer.MAX_VALUE;
            S[i] = 0;
            pi[i] = Integer.MAX_VALUE;
        }
        vertexCount = 0;
        edgeCount = 0;

        d[source] = 0;
        pi[source] = 0;
        a.decreaseKey(0, source);
        while (!a.isEmpty()) {
            Node u = a.getHead();
            a.delHead();
            // Perform the normal dijkstra here
            // Mark the vertex as visited
            S[u.getVertex()] = 1;
            this.vertexCount++;
            // Check current node with all adjacent vertex
            // This loop will take O(V)
            for (int v = 0; v < size; v++) {
                // if some edge exist && Edge not seen && edge is gives shorter path
                this.edgeCount++;
                if (g[u.getVertex()][v] > 0 &&
                        S[v] == 0 &&
                        d[v] > d[u.getVertex()] + g[u.getVertex()][v]) {
                    // update the path
                    d[v] = d[u.getVertex()] + g[u.getVertex()][v];
                    a.decreaseKey(d[u.getVertex()] + g[u.getVertex()][v], v);
                    pi[v] = u.getVertex();
                }
            }
        }
        print(false,isSimple);
    }

    public void print(boolean isList, boolean isSimple) {
        if (isList) {
            System.out.println("--------------- List results -----------------");
        }
        else {
            System.out.println("--------------- Matrix results -----------------");
        }
        if (isSimple) {
            System.out.println("Result is: ");
            System.out.println(Arrays.toString(S));
            System.out.println(Arrays.toString(pi));
            System.out.println(Arrays.toString(d));
        }
        
        System.out.printf("Number of vertex touched: %d\n", this.vertexCount);
        System.out.printf("Number of edge touched: %d\n", this.edgeCount);
        if (isList) {
            System.out.println("Heap operations as performed is as shown below:");
            System.out.printf("The number of compareCount: %d\n", q.getCounts()[0]);
            System.out.printf("The number of swapCount: %d\n", q.getCounts()[1]);
            System.out.printf("Total heap operations: %d\n", q.getCounts()[0] + q.getCounts()[1]);
        }
        else {
            System.out.println("Array operations as performed is as shown below:");
            System.out.printf("The number of compareCount: %d\n", a.getCounts()[0]);
            System.out.printf("The number of swapCount: %d\n", a.getCounts()[1]);
            System.out.printf("Total array operations: %d\n", a.getCounts()[0] + a.getCounts()[1]);
        }
    }
}