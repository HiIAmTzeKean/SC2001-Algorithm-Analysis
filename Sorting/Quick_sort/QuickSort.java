package Sorting.Quick_sort;

public class QuickSort {
    /**
     * 
     * @param array
     * @param start demotes the start of array to sort, we take it as index 0
     * @param end denotes the end of the array, we take it as size-1
     */
    public void sort(int[] array,int start, int end) {
        // while start is less than end
        // we continue to apply quicksort to it
        // until we reach base case, then we return
        if (start>=end) return;
        
        // we call partition to obtain the pivot
        // then call quicksort on left and right partition
        int pivot = partition(array, start, end);
        sort(array,start,pivot-1);
        sort(array,pivot+1,end);
    }
    public int partition(int[] array, int start, int end) {
        // we always take the first element as the pivot
        int pivot = array[start];
        // begin the partition process here
        // pivot - small list - big list
        int smallIndex = start;
        for (int i=start+1; i<=end; i++){
            if (array[i]>pivot) {
                // do nothing and just continue
            }
            else {
                // we have small index and we need to put it into small list
                // swap the big element with current small element
                int temp = array[i];
                array[i] = array[++smallIndex];
                array[smallIndex] = temp;
            }
        }
        // send pivot to be between the small and big list
        int temp = array[smallIndex];
        array[smallIndex] = pivot;
        array[start] = temp;
        return smallIndex;
    }
}
