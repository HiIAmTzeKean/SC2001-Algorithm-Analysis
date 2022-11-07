import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class merge_insertion_sort {
	private int[] arr;
	private long count;
	private int S;
	public merge_insertion_sort(int size, int S) {
		arr = new Random().ints(size,0,1000).toArray();
		this.S = S;
		this.count=0;
	}
	public int getS() {
		return S;
	}
	public long getCount() {
		return count;
	}
	public int getLen() {
		return arr.length;
	}
	public int[] getArr() {
		return arr;
	}
	public void compareHybrid() {
		int[] arr1 = Arrays.copyOfRange(arr, 0, arr.length);
		int [] arr2 = IntStream.range(0, 10000000).toArray(); 
		int [] arr3 = Arrays.copyOfRange(arr2, 0, arr2.length);
		for(int i = 0; i < arr3.length / 2; i++)
		{
		    int temp = arr3[i];
		    arr3[i] = arr3[arr3.length - i - 1];
		    arr3[arr3.length - i - 1] = temp;
		}
		
		System.out.println("========= Random sort comparison =========");
		count=0;
		long t1 = System.currentTimeMillis();
		mergesortModified(0,arr.length-1);
		System.out.println("Hybrid =========");
		System.out.printf("Size:%15d\tKey comparison is:%15d\tTime is: %10d\n",arr.length,count,t1=System.currentTimeMillis()-t1);
		long count1 = count;
		arr = Arrays.copyOfRange(arr1, 0, arr1.length);
		count=0;
		long t2 = System.currentTimeMillis();
		mergesortOriginal(0,arr.length-1);
		System.out.println("Original =========");
		System.out.printf("Size:%15d\tKey comparison is:%15d\tTime is: %10d\n",arr.length,count,t2=System.currentTimeMillis()-t2);
		long count2 = count;
		System.out.println();
		System.out.printf("The difference in Key comparison is: %d\n", count2-count1);
		System.out.printf("The difference in CPU time is:       %d\n",t2-t1);
		System.out.println();
		
		System.out.println("========= In order sort comparison =========");
		arr = Arrays.copyOfRange(arr2, 0, arr1.length);
		count=0;
		t1 = System.currentTimeMillis();
		mergesortModified(0,arr.length-1);
		System.out.println("Hybrid =========");
		System.out.printf("Size:%15d\tKey comparison is:%15d\tTime is: %10d\n",arr.length,count,t1=System.currentTimeMillis()-t1);
		count1 = count;
		arr = Arrays.copyOfRange(arr2, 0, arr1.length);
		count=0;
		t2 = System.currentTimeMillis();
		mergesortOriginal(0,arr.length-1);
		System.out.println("Original =========");
		System.out.printf("Size:%15d\tKey comparison is:%15d\tTime is: %10d\n",arr.length,count,t2=System.currentTimeMillis()-t2);
		count2 = count;
		System.out.println();
		System.out.printf("The difference in Key comparison is: %d\n", count2-count1);
		System.out.printf("The difference in CPU time is:       %d\n",t2-t1);
		System.out.println();
		
		System.out.println("========= Reverse sort comparison =========");
		arr = Arrays.copyOfRange(arr3, 0, arr1.length);
		count=0;
		t1 = System.currentTimeMillis();
		mergesortModified(0,arr.length-1);
		System.out.println("Hybrid =========");
		System.out.printf("Size:%15d\tKey comparison is:%15d\tTime is: %10d\n",arr.length,count,t1=System.currentTimeMillis()-t1);
		count1 = count;
		arr = Arrays.copyOfRange(arr3, 0, arr1.length);
		count=0;
		t2 = System.currentTimeMillis();
		mergesortOriginal(0,arr.length-1);
		System.out.println("Original =========");
		System.out.printf("Size:%15d\tKey comparison is:%15d\tTime is: %10d\n",arr.length,count,t2=System.currentTimeMillis()-t2);
		count2 = count;
		System.out.println();
		System.out.printf("The difference in Key comparison is: %d\n", count2-count1);
		System.out.printf("The difference in CPU time is:       %d\n",t2-t1);
		System.out.println();
	}
	
	public void insertionSort(int left, int right) {
		int i, j;
		for (i=left+1; i<=right; i++) {
			for (j=i; j>left; j--) {
				this.count++;
				if (arr[j-1]>arr[j]) {
					int temp=arr[j-1];
					arr[j-1]=arr[j];
					arr[j]=temp;
				}
				else break;
			}
		}
	}
	public void mergesortModified(int left, int right) {
		if (right-left<S) {
			insertionSort(left, right);
			return;
		}
		int mid = (right+left)/2;
		mergesortModified(left,mid);
		mergesortModified(mid+1,right);
		merge(left,right,mid);
	}
	public void mergesortOriginal(int left, int right) {
		if (right-left<=0)
			return;
		int mid = (right+left)/2;
		mergesortOriginal(left,mid);
		mergesortOriginal(mid+1,right);
		merge(left,right,mid);
	}
	public void merge(int left, int right, int mid) {
		int temp=left;
		int[] L = Arrays.copyOfRange(arr, temp, mid+1);
		int[] R = Arrays.copyOfRange(arr, mid+1, right+1);
		int i=0,j=0;
		while (i<mid-temp+1 && j<right-mid) {
			this.count++;
			if (L[i]<R[j])
				arr[left++]=L[i++];
			else
				arr[left++]=R[j++];
		}
		while (i<mid-temp+1)
			arr[left++]=L[i++];
		while (j<right-mid)
			arr[left++]=R[j++];
	}
}
