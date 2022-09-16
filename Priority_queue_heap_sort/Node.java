package Priority_queue_heap_sort;

public class Node implements Comparable<Node> {
    private int value;
    private int vertex;
    
    public Node (int value, int vertex){
        this.value = value;
        this.vertex = vertex;
    }
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public int getVertex() {
        return vertex;
    }
    public void setVertex(int vertex) {
        this.vertex = vertex;
    }
    @Override
    public int compareTo(Node node2) {
        return (this.value - node2.value);
    }
    public void print() {
        System.out.println("Value: " + this.value + "Vertex: " + this.vertex);
    }
}