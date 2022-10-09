package Sorting.QuickSelect;

public class QuickSelectApp {
    public static void main(String args []) {
        QuickSelect q = new QuickSelect();
        int [] array = {3,2,3,1,2,4,5,5,6};
        int k = 5;
        int element = q.findKValue(array, 0, array.length-1, k-1);
        System.out.println(element);
    }
}
