public class merge_insertion_App {
	public static void main (String[] arg) {
		System.out.printf("============ Starting program ============\n");
		
		// partOne();
		// partTwo();
		// partThree();
		
		merge_insertion_sort run1 = new merge_insertion_sort(10000000,45);
		run1.compareHybrid();
		System.out.printf("============ Ending program ============\n");
	}
	public static void partThree() {
		System.out.println("Part (3)");
		System.out.println("The optimal k value found was S=45");
		System.out.println("========= Hybrid =========");
		merge_insertion_sort run1 = new merge_insertion_sort(10000000,45);
		long t1 = System.currentTimeMillis();
		run1.mergesortModified(0, run1.getLen()-1);
		System.out.printf("Size:%15d\tKey comparison is:%15d\tTime is: %10d\n",run1.getArr().length,run1.getCount(),t1=System.currentTimeMillis()-t1);
		System.out.println();
		
		System.out.println("========= Original =========");
		merge_insertion_sort run2 = new merge_insertion_sort(10000000,45);
		long t2 = System.currentTimeMillis();
		run2.mergesortOriginal(0, run2.getLen()-1);
		System.out.printf("Size:%15d\tKey comparison is:%15d\tTime is: %10d\n",run2.getArr().length,run2.getCount(),t2=System.currentTimeMillis()-t2);
		System.out.println();
		
		System.out.println("========= Analysis =========");
		System.out.printf("The difference in Key comparison is: %d\n", run2.getCount() - run1.getCount());
		System.out.printf("The difference in CPU time is:       %d\n",t2-t1);
		
	}
	public static void partTwo() {
		System.out.println("Part (2)");
		System.out.println("We fix size of array and vary S to find out what is the effect");
		for (int i=1; i<101; i+=10) {
			merge_insertion_sort run1 = new merge_insertion_sort(1000000,i);
			long t = System.currentTimeMillis();
			run1.mergesortModified(0, run1.getLen()-1);
			System.out.printf("For S:%3d\tSize:%15d\tKey comparison is:%15d\tTime is: %10d\n",run1.getS(),run1.getArr().length,run1.getCount(),System.currentTimeMillis()-t);
		}
		System.out.println();
		System.out.println("We see that the key comparison and CPU time between S=41 and S=51 is lowest");
		System.out.println();
		
		// set the t
		int LOOPS = 8;
		for (int i=41; i<51; i+=1) {
			double aveTime=0;
			int aveKeys=0;
			for (int j=0; j<LOOPS; j++) {
				merge_insertion_sort run1 = new merge_insertion_sort(1000000,i);
				long t = System.currentTimeMillis();
				run1.mergesortModified(0, run1.getLen()-1);
				aveKeys+=run1.getCount();
				aveTime+=System.currentTimeMillis()-t;
			}
			
			System.out.printf("For S:%3d\tSize:%15d\tKey comparison is:%15d\tTime is: %10.0f\n",i,1000000,aveKeys/LOOPS,(aveTime/LOOPS));
		}
		System.out.println();
		System.out.println("We can check that 45 gives us the lowest key comparison and CPU time");
	}
	public static void partOne() {
		System.out.printf("Part (1)\n");
		System.out.println();
		for (int i=1000; i<100000001; i*=100) {
			merge_insertion_sort run1 = new merge_insertion_sort(i,2);
			long t = System.currentTimeMillis();
			run1.mergesortModified(0, run1.getLen()-1);
			System.out.printf("For S:%3d\tSize:%15d\tKey comparison is:%15d\tTime is: %10d\n",run1.getS(),run1.getArr().length,run1.getCount(),System.currentTimeMillis()-t);
		}
		System.out.println();
		for (int i=1000; i<100000001; i*=100) {
			merge_insertion_sort run1 = new merge_insertion_sort(i,10);
			long t = System.currentTimeMillis();
			run1.mergesortModified(0, run1.getLen()-1);
			System.out.printf("For S:%3d\tSize:%15d\tKey comparison is:%15d\tTime is: %10d\n",run1.getS(),run1.getArr().length,run1.getCount(),System.currentTimeMillis()-t);
		}
		System.out.println();
		for (int i=1000; i<100000001; i*=100) {
			merge_insertion_sort run1 = new merge_insertion_sort(i,100);
			long t = System.currentTimeMillis();
			run1.mergesortModified(0, run1.getLen()-1);
			System.out.printf("For S:%3d\tSize:%15d\tKey comparison is:%15d\tTime is: %10d\n",run1.getS(),run1.getArr().length,run1.getCount(),System.currentTimeMillis()-t);
		}
		System.out.println();
	}
}
