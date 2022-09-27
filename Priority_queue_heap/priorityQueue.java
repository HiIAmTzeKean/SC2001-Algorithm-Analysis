package Priority_queue_heap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import Node.Node;

public class priorityQueue {
    private List<Node> arr;
    private int[] countArray;
    private HashMap<Integer,Integer> map;
    private heap h;
    
    public priorityQueue(){
        h = new heap();
        // Indexing of array starts from 0
        arr = new ArrayList<Node>();
        // Index of mapping starts from 1
        // Concept is to follow the indexing of heap sort
        map = new HashMap<Integer,Integer>();
        // countArray [operationCount, swapCount]
        countArray = new int[] {0,0};
    }
    public Node getHead() {
        return arr.get(0);
    }
    public void delHead() {
        h.removeHead(arr,map,countArray);
    }
    public void print(){
        for (int i=0; i<arr.size(); i++) {
            arr.get(i).print();
        }
        System.out.println(map.toString());
    }
    /**
     * Decrease key will decrease the distance to some unvisted vertex if it is in queue
     * else it will add a new node
     * @param weight
     * @param vertex
     */
    public void decreaseKey(int weight, int vertex){
        if (map.get(vertex)!=null)
            h.decreaseKey(arr, weight, vertex, map,countArray);
        else
            h.addNode(arr, weight, vertex, map,countArray);
    }
    public boolean isEmpty(){
        return arr.size()==0;
    }
    public int[] getCounts(){
        return countArray;
    }
}
