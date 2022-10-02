package Graphs;

public class DijkstraApp {
    public static void main(String arg []) {
        FullyConnectedSingleWeightSimple();
    }

    public static void DAGSimple() {
        AdjacencyList l = new AdjacencyList(6);
        l.addNode(0, 1, 1);
        l.addNode(1, 2, 1);
        l.addNode(2, 3, 1);
        l.addNode(3, 4, 1);
        l.addNode(4, 5, 1);

        int[][]g=new int[6][6];
        g[0][1]=1;
        g[1][2]=1;
        g[2][3]=1;
        g[3][4]=1;
        g[4][5]=1;

        Dijkstra d = new Dijkstra();
        d.pathFind(l,0,true);
        System.out.println();
        d.pathFind(g, 0, true);
    }
    public static void DAGComplex() {
        int size = 100;
        AdjacencyList l = new AdjacencyList(size);
        for (int i=0; i<size-1; i++) {
            l.addNode(i, i+1, 1);
        }
        int[][]g=new int[size][size];
        for (int i=0; i<size-1; i++) {
            g[i][i+1]=1;
        }

        Dijkstra d = new Dijkstra();
        d.pathFind(l,0, false);
        System.out.println();
        d.pathFind(g, 0, false);
    }
    public static void SparseSimple() {
        AdjacencyList l = new AdjacencyList(6);
        l.addNode(0, 1, 1);
        l.addNode(0, 2, 1);
        l.addNode(0, 3, 1);
        l.addNode(0, 4, 1);
        l.addNode(0, 5, 1);

        int[][]g=new int[6][6];
        g[0][1]=1;
        g[0][2]=1;
        g[0][3]=1;
        g[0][4]=1;
        g[0][5]=1;

        Dijkstra d = new Dijkstra();
        d.pathFind(l,0,true);
        System.out.println();
        d.pathFind(g, 0, true);
    }
    public static void SparseComplex() {
        int size = 100;
        AdjacencyList l = new AdjacencyList(size);
        for (int i=0; i<size-1; i++) {
            l.addNode(i, i+1, 1);
        }

        int[][]g=new int[size][size];
        for (int i=0; i<size-1; i++) {
            g[i][i+1]=1;
        }


        Dijkstra d = new Dijkstra();
        d.pathFind(l,0,false);
        System.out.println();
        d.pathFind(g, 0, false);
    }
    public static void SparseBiSimple() {
        AdjacencyList l = new AdjacencyList(6);
        for (int i=0; i<6-1; i++) {
            l.addNode(i, i+1, 1);
            l.addNode(i+1, i, 1);
        }

        int[][]g=new int[6][6];
        for (int i=0; i<6-1; i++) {
            g[i][i+1]=1;
            g[i+1][i]=1;
        }

        Dijkstra d = new Dijkstra();
        d.pathFind(l,0,true);
        System.out.println();
        d.pathFind(g, 0, true);
    }
    public static void FullyConnectedSingleWeightSimple() {
        AdjacencyList l = new AdjacencyList(6);
        for (int i=0; i<6; i++)
            for (int j=0; j<6; j++)
                l.addNode(i, j, 10);

        int[][]g=new int[6][6];
        for (int i=0; i<6; i++)
            for (int j=0; j<6; j++)
                g[i][j]=10;

        Dijkstra d = new Dijkstra();
        d.pathFind(l,0,true);
        System.out.println();
        d.pathFind(g, 0, true);
    }
    public static void FullyConnectedSingleWeightcomplex() {
        int size = 100;
        AdjacencyList l = new AdjacencyList(size);
        for (int i=0; i<size; i++)
            for (int j=0; j<size; j++)
                l.addNode(i, j, 10);

        int[][]g=new int[size][size];
        for (int i=0; i<size; i++)
            for (int j=0; j<size; j++)
                g[i][j]=10;

        Dijkstra d = new Dijkstra();
        d.pathFind(l,0,false);
        System.out.println();
        d.pathFind(g, 0, false);
    }
    public static void FullyConnectedMultiWeightSimple() {
        AdjacencyList l = new AdjacencyList(6);
        for (int i=0; i<6; i++) {
            int count=1;
            for (int j=5; j>=0; j--)
                l.addNode(i, j, count++);
        }
        int[][]g=new int[6][6];
        for (int i=0; i<6; i++) {
            int count=1;
            for (int j=5; j>=0; j--)
                g[i][j]=count++;
        }

        Dijkstra d = new Dijkstra();
        d.pathFind(l,0,true);
        System.out.println();
        d.pathFind(g, 0, true);
    }
    public static void FullyConnectedMultiWeightComplex() {
        int size = 100;
        AdjacencyList l = new AdjacencyList(size);
        for (int i=0; i<size; i++) {
            int count=1;
            for (int j=100-1; j>=0; j--)
                l.addNode(i, j, count++);
        }
        int[][]g=new int[size][size];
        for (int i=0; i<size; i++) {
            int count=1;
            for (int j=size-1; j>=0; j--)
                g[i][j]=count++;
        }

        Dijkstra d = new Dijkstra();
        d.pathFind(l,0,false);
        System.out.println();
        d.pathFind(g, 0, false);
    }
}
