package Graphs;

public class dijkstraListApp {
    public static void main(String arg []) {
        AdjacencyList l = new AdjacencyList(5);
        l.addNode(0, 1, 7);
        l.addNode(0, 2, 12);
        l.addNode(1, 2, 2);
        l.addNode(1, 3, 9);
        l.addNode(2, 4, 10);

        int[][]g=new int[5][5];
        g[0][1]=7;
        g[0][2]=12;
        g[1][2]=2;
        g[1][3]=9;
        g[2][4]=10;

        dijkstra d = new dijkstra();
        d.pathFind(l,0);
        d.pathFind(g, 0);
    }
}
