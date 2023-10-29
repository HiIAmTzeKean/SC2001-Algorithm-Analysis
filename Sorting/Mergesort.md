---
tags:
  - 🌱
  - ComputerScience 
date: 14--Aug--2022
---

# Mergesort

## Code
```java
public class Mergesort {
	public static void sort(int array[],int left, int right) {
		// if left is greater than right
		// indicates that there is no more sorting to be done for the block
		if (left>=right) return;
		
		// Perform the sorting here
		int middle;
		middle = (left+right-1)/2;
		// Sort left
		sort(array,left,middle);
		// Sort right
		sort(array, middle+1,right);
	
		// Merge both
		merge(array,left,right,middle);
	}
	
	public static void merge(int array[], int left, int right, int middle) {
		// Merge the left and right side
		// Insert the elements into the correct position
		// Create a placeholder to store the current array for
		// the swapping
		int leftLimit = middle-left+1;
		int rightLimit = right-middle;
		int Larray[] = new int [leftLimit];
		int Rarray[] = new int [rightLimit];
		
		// copy over the array
		for (int i=0; i<leftLimit; i++) {
			Larray[i]=array[left+i];
		}
		for (int j=0; j<rightLimit; j++) {
			Rarray[j]=array[middle+1+j];
		}
		
		// Iterate and insert the ordered values
		int i=0,j=0;
		while (i<(leftLimit) && j<rightLimit) {
			// Perform the comparison with left and right side
			if (Larray[i]<Rarray[j]) {
				// if left side lower
				// insert into array and increment left pointer
				array[left++] = Larray[i++];
			}
			else {
				// if right side is lower
				// insert into array and increment the right pointer
				array[left++] = Rarray[j++];
			}
		}
		// insert remainder
		while (i<leftLimit) {
			array[left++] = Larray[i++];
		}
		while (j<rightLimit) {
			array[left++] = Rarray[j++];
		}
	}
```

## Time complexity


## Comparison with other sort


---
Links: 