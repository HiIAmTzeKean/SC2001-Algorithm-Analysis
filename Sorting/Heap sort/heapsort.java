import java.util.Arrays;
import java.util.Random;
public class heapsort<T extends Comparable<T>> {
    // array that will act as a heap
    private T[] arr;
    private int start = 1;
    public heapsort(int size){
        arr = new T[size];
    }
    public heapsort(){
        int size = 0;
        arr = new Random().ints(size,0,1000).toArray();
    }
    public void sort() {
        heapify(start);
        printArr();
        for (int i=arr.length; i>1; i--) {
            // get head
            int temp = getMax();
            // replace head with the last leaf node
            arr[start-1] = arr[i-1];
            // put head in the free space
            arr[i-1] = temp;
            // call fixHeap to preserve heap structure
            fixHeapRecursive(start,i-1);
            // repeat till heap has one element
        }
    }
    //------------------------------
    // Function to obtain the head of the array
    //------------------------------
    public int getMax() {
        return arr[start-1];
    }
    public void heapify(int index) {
        // rememmber return condition
        if (index>arr.length) return;
        // Perform post order heapify process
        heapify(index *2);
        heapify(index *2 +1);
        fixHeapRecursive(index, arr.length);        
    }
    public void fixHeapRecursive(int index, int end) {
        if (index>=end) return;

        int largest = index;
        // Check root with left child
        if (2*index<=end && arr[2*index-1]>arr[largest-1])
            largest = 2*index;
        // Check root with right child
        if (2*index+1<=end && arr[2*index+1-1]>arr[largest-1])
            largest = 2*index+1;
        // Check if root is still largest
        if (largest!=index) {
            // perform swap here
            int temp = arr[index-1];
            arr[index-1] = arr[largest-1];
            arr[largest-1] = temp;
            // call fixHeap()
            // we need to add 1 to reset the indexing back to
            // 1 to n
            fixHeapRecursive(largest,end);
        }
    }
    public void printArr(){
        System.out.println(Arrays.toString(arr));
    }
}
