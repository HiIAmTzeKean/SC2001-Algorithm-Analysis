package Sorting.Quick_sort;

public class QuickSortApp {
    public static void main (String args []) {
        QuickSort q = new QuickSort();
        int arr[] = { 10, 7, 8, 9, 1, 5 };
        q.sort(arr, 0, arr.length-1);
        printArray(arr, arr.length);
    }
    static void printArray(int[] arr, int size)
    {
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
  
        System.out.println();
    }
}
