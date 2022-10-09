package Priority_queue;

import java.util.HashMap;
import Node.Node;

public class PriorityQueueArray extends PriorityQueueClass {
    private Node[] array;
    private HashMap<Integer,Integer> map;
    int size;
    int[] countArray;

    public PriorityQueueArray(int initSize) {
        array = new Node[initSize];
        size = 0;
        map = new HashMap<Integer,Integer>();
        // index 0 is the operations
        // index 1 is the swaps
        countArray = new int[2];
    }
    public boolean isEmpty() {
        return size==0;
    }
    public int[] getCounts(){
        return countArray;
    }
    public Node getHead() {
        return array[0];
    }
    public void delHead() {
        // shift all elements to front by 1
        for (int i=0; i<size-1; i++){
            countArray[1]++;
            array[i] = array[i+1];
            if (map.containsKey(array[i].getVertex())) {
                map.replace(array[i].getVertex(), i);
            }
        }
        size--;
    }
    public void decreaseKey(int weight, int vertex){
        if (map.get(vertex)!=null) {
            // decrease key
            array[map.get(vertex)].setValue(weight);
            // find location to insert
            // since we only decrease, forward scan

            int index = map.get(vertex);
            // increment count for the first loop
            countArray[0]++;
            while (index>=1 && array[index-1].compareTo(array[index])>1) {
                //swap here
                countArray[1]++;
                Node temp = array[index-1];
                array[index-1]=array[index];
                array[index] = temp;
                // update the mapping
                map.replace(temp.getVertex(), index);
                index--;
                countArray[0]++;
            }
            map.replace(array[index].getVertex(), index);
        }
        else{
            // add node here
            array[size] = new Node(weight,vertex);

            // perform insert to correct index
            int index = size;
            countArray[0]++;
            while (index>=1 && array[index-1].compareTo(array[index])>1 ) {
                countArray[0]++;
                //swap here
                countArray[1]++;
                Node temp = array[index-1];
                array[index-1]=array[index];
                array[index] = temp;
                // update the mapping
                map.replace(temp.getVertex(), index);
                index--;
            }
            map.put(vertex, index);
            size++;
        }
    }
}