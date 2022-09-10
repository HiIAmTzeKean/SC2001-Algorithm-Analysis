import java.util.ArrayList;


public class DirectedGraph {
    // We define a directed graph here
    // The graph can be either adjacency matrix or list

    private int size;
    private int[][] g;
    public DirectedGraph(int size) {
        this.size = size;
        this.g = new int[size][size]; 
    }
    public void addEdge(int v1, int v2, int weight) {
        g[v1][v2] = weight;
    }
    public int getWeght(int v1, int v2) {
        return g[v1][v2];
    }
}