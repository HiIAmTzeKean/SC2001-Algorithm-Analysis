package Sorting.QuickSelect;

public class QuickSelect {
    /**
     * Using Quick select we are able to selectively sort one side of a partition
     * This allows us to locate the k^th element of a sorted array in O(n) time
     * Our worse case is the same as quick sort worse case = O(n^2)
     * This hapends when we pick the smallest or largest element
     * The best case is when we pick the pivot that splits the list into 2 halves
     * so we have the recurrance expression T(n) = T(n/2) + c*n
     * Apply master theorem and we have T(n) = O(n)
     * @param array
     * @param start
     * @param end
     * @param k
     * @return
     */
    public int findKValue(int[] array, int start, int end, int k){
        // we want to find the k value of a sorted array
        // so we perform the sort till k element is found
        if (start<=end){
            int pivotIndex = partition(array,start,end);
            if (pivotIndex<k) {
                // k is on the right partition
                return findKValue(array,pivotIndex+1,end,k);
            }
            else if (pivotIndex>k) {
                return findKValue(array,start,pivotIndex-1,k);
            }
            else {
                // else our pivot is the index we are looking for
                return array[pivotIndex];
            }
        }
        return 0;
    }
    public int partition(int[] array, int start, int end) {
        // same as the quick sort partition
        // pick a pivot
        int middle = (start+end)/2;
        int pivot = array[middle];
        // swap the pivot with the first element
        int temp = array[start];
        array[start] = array[middle];
        array[middle] = temp;

        // begin the partitioning process
        // we keep big list to be on the left
        // pivot - big - small
        int bigIndex = start;
        for (int i=start+1; i<=end; i++) {
            if (array[i]<pivot) {
                // small list do not need to do anything
            }
            else {
                // we meet a big element
                // must perform swap
                temp = array[i];
                array[i] = array[++bigIndex];
                array[bigIndex] = temp;
            }
        }
        // return pivot to be between small and big
        // swap here
        temp = array[bigIndex];
        array[bigIndex] = pivot;
        array[start] = temp;
        return bigIndex;
    }
}
