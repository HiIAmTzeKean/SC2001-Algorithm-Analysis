package Priority_queue_heap;

import java.util.HashMap;
import java.util.List;
import Node.Node;

public class heap {
    // array that will act as a heap
    private int start = 1;

    public void heapify(List<Node> arr, int index,HashMap<Integer, Integer> map, int[] countArray) {
        if (index > arr.size() / 2)
            return;
        heapify(arr, 2 * index, map, countArray);
        heapify(arr, 2 * index + 1, map, countArray);
        fixHeap(arr, index, arr.size(), map, countArray);
    }

    public void fixHeap(List<Node> arr, int index, int size, HashMap<Integer, Integer> map, int[] countArray) {
        if (2 * index > size)
            return;

        int smallest = index;
        countArray[0]++;
        // if left child within bound, compare it to index
        if (2 * index <= size && arr.get(2 * index - 1).compareTo(arr.get(smallest - 1)) < 0)
            smallest = 2 * index;
        countArray[0]++;
        // Repeat for right child
        if (2 * index + 1 <= size && arr.get(2 * index + 1 - 1).compareTo(arr.get(smallest - 1)) < 0)
            smallest = 2 * index + 1;

        // swap for the smallest child
        // if swap then fix heap
        countArray[0]++;
        if (smallest != index) {
            countArray[1]++;
            Node temp = arr.get(smallest - 1);
            map.replace(arr.get(index - 1).getVertex(), smallest);
            arr.set(smallest - 1, arr.get(index - 1));
            arr.set(index - 1, temp);
            map.replace(temp.getVertex(), index);
            fixHeap(arr, smallest, size, map, countArray);
        }
    }

    public void sort(List<Node> arr, HashMap<Integer, Integer> map, int[] countArray) {
        heapify(arr, start, map, countArray);
        // get Max from head
        // Store max in temp
        // take leaf node and insert to head
        // Store temp into empty postition
        // fixHeap where size decrements by 1 for each iteration
        // Repeat process till heap size = 1
        for (int i = arr.size(); i > 2; i--) {
            Node temp = arr.get(start - 1);
            arr.set(start - 1, arr.get(i - 1));
            arr.set(i - 1, temp);
            fixHeap(arr, start, i - 1, map, countArray);
        }
    }

    public int addNode(List<Node> arr, int weight, int vertex, HashMap<Integer, Integer> map, int[] countArray) {
        // add new node to array first
        arr.add(new Node(weight, vertex));
        map.put(vertex, arr.size());
        // check if current node is smaller than the root
        // if smaller swap
        // else exit
        // repeat till root node
        int index = arr.size();
        bubbleUp(arr, index, map, countArray);
        return 1;
    }

    public void bubbleUp(List<Node> arr, int index, HashMap<Integer, Integer> map, int[] countArray) {
        int root;
        // loop while index is not root
        while (index>1) {
            // Trace the number of operations needed
            countArray[0]++;

            // check if index is odd first
            // if the index is odd then the root=index-1 div 2
            if (index%2 == 1)
                root = (index-1)/2;
            else 
                root = index/2;
            
            countArray[0]++;
            // Check if there is a need for a swap to be done
            // If no swaps needs to be done, then we exit
            if (arr.get(root-1).compareTo(arr.get(index-1))>0){
                countArray[1]++;
                // Perform a swap with child and the root node
                // We also need to update the map for tracing purpose
                Node temp = arr.get(index-1);
                map.replace(arr.get(root-1).getVertex(), index);
                arr.set(index-1,arr.get(root-1));
                arr.set(root-1,temp);
                map.replace(temp.getVertex(), root);
                // repeat
                index = root;
                countArray[0]++;
            }
            else return;
        }
    }

    public void removeHead(List<Node> arr, HashMap<Integer, Integer> map, int[] countArray) {
        countArray[0]++;
        
        // replace head with leaf
        Node temp = arr.get(0);
        arr.set(0, arr.get(arr.size() - 1));
        map.replace(arr.get(arr.size() - 1).getVertex(), 1);
        arr.remove(arr.size() - 1);
        map.remove(temp.getVertex());

        // fixheap
        fixHeap(arr, 1, arr.size(), map, countArray);
        return;
    }

    public void decreaseKey(List<Node> arr, int weight, int vertex, HashMap<Integer, Integer> map, int[] countArray) {
        int index = map.get(vertex);
        Node temp = arr.get(index - 1);
        temp.setValue(weight);

        // This operation takes O(lg(V))
        bubbleUp(arr, index, map, countArray);
    }
}
