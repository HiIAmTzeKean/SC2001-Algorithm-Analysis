package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import Node.Node;

public class AdjacencyList {
    private int size;
    private List<LinkedList<Node>> listVertex;
    public AdjacencyList(int size) {
        this.size=size;
        listVertex = new ArrayList<LinkedList<Node>>();
        for (int i=0; i<size; i++) {
            listVertex.add(new LinkedList<Node>());
        }
    }
    public void addNode(int v1, int v2, int weight) {
        listVertex.get(v1).add(new Node(weight,v2));
    }
    public void updateNode(int v1, int v2, int weight) {
        listVertex.get(v1).get(v2).setValue(weight);
    }
    public LinkedList<Node> getNodeList(int v1) {
        return listVertex.get(v1);
    }
    public int size() {
        return this.size;
    }
}
