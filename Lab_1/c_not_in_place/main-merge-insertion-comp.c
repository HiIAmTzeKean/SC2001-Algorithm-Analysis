#include <stdio.h>
#include <stdlib.h>
#include <time.h> 
// Define threshold
#define S 43
// https://www.onlinegdb.com/online_c_compiler
// https://www.geeksforgeeks.org/merge-sort/
void merge(int arr[], int l, int m, int r, long *comp)
{
    int i, j, k;
    int n1 = m - l + 1;
    int n2 = r - m;

    int *L, *R;
    L = (int*)malloc((n1+1) * sizeof(int));
    R = (int*)malloc((n2+1) * sizeof(int));

    for (i = 0; i < n1; i++)
        L[i] = arr[l + i];
    for (j = 0; j < n2; j++)
        R[j] = arr[m + 1 + j];
    i = 0; // Initial index of first subarray
    j = 0; // Initial index of second subarray
    k = l; // Initial index of merged subarray
    while (i < n1 && j < n2) {
        if (L[i] <= R[j]) {
            arr[k] = L[i];
            i++;
        }
        else {
            arr[k] = R[j];
            j++;
        }
        k++;
        *comp = *comp + 1;
    }
    while (i < n1) {
        arr[k] = L[i];
        i++;
        k++;
    }
    while (j < n2) {
        arr[k] = R[j];
        j++;
        k++;
    }
}

void mergesort(int arr[], int l, int r, long *comp)
{
    if (l < r) {
        int m = l + (r - l) / 2;
        mergesort(arr, l, m, comp);
        mergesort(arr, m + 1, r, comp);
        merge(arr, l, m, r, comp);
    }
}
// https://www.geeksforgeeks.org/insertion-sort/
void insertionSort(int arr[], int n, int m, long *comp)
{
    int i, key, j;
    for (i = n+1; i < m; i++) {
        key = arr[i];
        j = i - 1;

        while (j >= n && arr[j] > key) {
            arr[j + 1] = arr[j];
            j = j - 1;
            *comp = *comp + 1;
        }
        arr[j + 1] = key;
    }
}

void merge_insertionSort (int arr[], int n, int m, long *comp){
    if (m-n > S){
        int mid = n + (m - n) / 2;
        merge_insertionSort(arr, n, mid, comp);
        merge_insertionSort(arr, mid + 1, m, comp);
        merge(arr, n, mid, m, comp);
    }else{
        insertionSort(arr, n, m, comp);
    }
}

int main(){
    // for (int e=1; e<=10;e++){
    //     int S = 2*e;
    //     printf("Threshold for this iteration is: %d\n" , S);
    if (1){
        int * array_million, *array_hundred_thousand, *array_ten_thousand, *array_thousand, *array_ten_million, *array_hundred_million;
        array_thousand = (int*)malloc(1000 * sizeof(int));
        for (int i=0; i<1000; i++) {array_thousand[i]=rand()%100;}
        array_ten_thousand = (int*)malloc(10000 * sizeof(int));
        for (int i=0; i<10000; i++) {array_ten_thousand[i]=rand()%100;}
        array_hundred_thousand = (int*)malloc(100000 * sizeof(int));
        for (int i=0; i<100000; i++) {array_hundred_thousand[i]=rand()%100;}
        array_million = (int*)malloc(1000000 * sizeof(int));
        for (int i=0; i<1000000; i++) {array_million[i]=rand()%100;}
        array_ten_million = (int*)malloc(10000000 * sizeof(int));
        for (int i=0; i<10000000; i++) {array_ten_million[i]=rand()%100;}
        array_hundred_million = (int*)malloc(100000000 * sizeof(int));
        for (int i=0; i<100000000; i++) {array_hundred_million[i]=rand()%100;}

        // array_thousand
        // --------------------------------------------------------------------------------------------------------------------------------------------------------
        // Testing individual sorting algo
        // insertionSort(array_thousand,999);
        // for (int i=0; i<1000; i++) {printf("%d ", array_thousand[i]);}
        long comp = 0;
        double time_spent = 0.0;
        clock_t begin = clock();
        mergesort(array_thousand,0,999, &comp);
        clock_t end = clock();
        time_spent += (double)(end - begin) / CLOCKS_PER_SEC;
        printf("The merge_Sort for array_thousand time is %f seconds\n", time_spent);
        printf("The # key comparison of merge_Sort for array_thousand time is %ld \n", comp);
        // for (int i=0; i<10000; i++) {printf("%d ", array_ten_thousand[i]);}
        // mergesort(array_hundred_thousand,0,99999); Laptop destroyed with error "exited with code=3221225477 in 7.121 seconds"
        // for (int i=0; i<100000; i++) {printf("%d ", array_ten_thousand[i]);}


        // Create another random array of size ten thousand
        for (int i=0; i<1000; i++) {array_thousand[i]=rand()%100;}

        // Testing merge-insertion sort
        comp = 0;
        time_spent = 0.0;
        begin = clock();
        merge_insertionSort(array_thousand,0,999, &comp);
        end = clock();
        time_spent += (double)(end - begin) / CLOCKS_PER_SEC;
        printf("The merge_insertionSort for array_thousand time is %f seconds\n", time_spent);
        printf("The # key comparison of merge_insertionSort for array_thousand time is %ld \n", comp);
        free(array_thousand);
        // --------------------------------------------------------------------------------------------------------------------------------------------------------

        // array_ten_thousand
        // --------------------------------------------------------------------------------------------------------------------------------------------------------
        // Testing merge_sort algo
        comp = 0;
        time_spent = 0.0;
        begin = clock();
        mergesort(array_ten_thousand,0,9999, &comp);
        end = clock();
        time_spent += (double)(end - begin) / CLOCKS_PER_SEC;
        printf("The merge_Sort for array_ten_thousand time is %f seconds\n", time_spent);
        printf("The # key comparison of merge_Sort for array_ten_thousand time is %ld \n", comp);
        for (int i=0; i<1000; i++) {array_ten_thousand[i]=rand()%100;}

        // Testing merge-insertion sort
        comp = 0;
        time_spent = 0.0;
        begin = clock();
        merge_insertionSort(array_ten_thousand,0,9999, &comp);
        end = clock();
        time_spent += (double)(end - begin) / CLOCKS_PER_SEC;
        printf("The merge_insertionSort for array_ten_thousand time is %f seconds\n", time_spent);
        printf("The # key comparison of merge_insertionSort for array_ten_thousand time is %ld \n", comp);
        free(array_ten_thousand);
        // --------------------------------------------------------------------------------------------------------------------------------------------------------

        // array_hundred_thousand
        // --------------------------------------------------------------------------------------------------------------------------------------------------------
        // Testing merge_sort algo
        comp = 0;
        time_spent = 0.0;
        begin = clock();
        mergesort(array_hundred_thousand,0,99999, &comp);
        end = clock();
        time_spent += (double)(end - begin) / CLOCKS_PER_SEC;
        printf("The merge_Sort for array_hundred_thousand time is %f seconds\n", time_spent);
        printf("The # key comparison of merge_Sort for array_hundred_thousand time is %ld \n", comp);
        for (int i=0; i<10000; i++) {array_hundred_thousand[i]=rand()%100;}

        // Testing merge-insertion sort
        comp = 0;
        time_spent = 0.0;
        begin = clock();
        merge_insertionSort(array_hundred_thousand,0,99999, &comp);
        end = clock();
        time_spent += (double)(end - begin) / CLOCKS_PER_SEC;
        printf("The merge_insertionSort for array_hundred_thousand time is %f seconds\n", time_spent);
        printf("The # key comparison of merge_insertionSort for array_hundred_thousand time is %ld \n", comp);
        free(array_hundred_thousand);
        // --------------------------------------------------------------------------------------------------------------------------------------------------------


        // array_million
        // --------------------------------------------------------------------------------------------------------------------------------------------------------
        // Testing merge_sort algo
        comp = 0;
        time_spent = 0.0;
        begin = clock();
        mergesort(array_million,0,999999, &comp);
        end = clock();
        time_spent += (double)(end - begin) / CLOCKS_PER_SEC;
        printf("The merge_Sort for array_million time is %f seconds\n", time_spent);
        printf("The # key comparison of merge_Sort for array_million time is %ld \n", comp);
        for (int i=0; i<1000000; i++) {array_million[i]=rand()%100;}

        // Testing merge-insertion sort
        comp = 0;
        time_spent = 0.0;
        begin = clock();
        merge_insertionSort(array_million,0,999999, &comp);
        end = clock();
        time_spent += (double)(end - begin) / CLOCKS_PER_SEC;
        printf("The merge_insertionSort for array_million time is %f seconds\n", time_spent);
        printf("The # key comparison of merge_insertionSort for array_million time is %ld \n", comp);
        free(array_million);
        // --------------------------------------------------------------------------------------------------------------------------------------------------------


        
        // array_ten_million
        // --------------------------------------------------------------------------------------------------------------------------------------------------------
        // Testing merge_sort algo
        comp = 0;
        time_spent = 0.0;
        begin = clock();
        mergesort(array_ten_million,0,9999999, &comp);
        end = clock();
        time_spent += (double)(end - begin) / CLOCKS_PER_SEC;
        printf("The merge_Sort for array_ten_million time is %f seconds\n", time_spent);
        printf("The # key comparison of merge_Sort for array_ten_million time is %ld \n", comp);
        for (int i=0; i<10000000; i++) {array_ten_million[i]=rand()%100;}

        // // Testing merge-insertion sort
        comp = 0;
        time_spent = 0.0;
        begin = clock();
        merge_insertionSort(array_ten_million,0,9999999, &comp);
        end = clock();
        time_spent += (double)(end - begin) / CLOCKS_PER_SEC;
        printf("The merge_insertionSort for array_ten_million time is %f seconds\n", time_spent);
        printf("The # key comparison of merge_insertionSort for array_ten_million time is %ld \n", comp);
        free(array_ten_million);
        // --------------------------------------------------------------------------------------------------------------------------------------------------------
    
         // array_hundred_million
        // --------------------------------------------------------------------------------------------------------------------------------------------------------
        // Testing merge_sort algo
        comp = 0;
        time_spent = 0.0;
        begin = clock();
        mergesort(array_hundred_million,0,99999999, &comp);
        end = clock();
        time_spent += (double)(end - begin) / CLOCKS_PER_SEC;
        printf("The merge_Sort for array_hundred_million time is %f seconds\n", time_spent);
        printf("The # key comparison of merge_Sort for array_hundred_million time is %ld \n", comp);
        for (int i=0; i<100000000; i++) {array_hundred_million[i]=rand()%100;}

        // // Testing merge-insertion sort
        comp = 0;
        time_spent = 0.0;
        begin = clock();
        merge_insertionSort(array_hundred_million,0,99999999, &comp);
        end = clock();
        time_spent += (double)(end - begin) / CLOCKS_PER_SEC;
        printf("The merge_insertionSort for array_hundred_million time is %f seconds\n", time_spent);
        printf("The # key comparison of merge_insertionSort for array_hundred_million time is %ld \n", comp);
        free(array_hundred_million);
        // --------------------------------------------------------------------------------------------------------------------------------------------------------
    }
    
}


// Reference:
// 1. SC2001 Note
// File Lec-2_Insertion Sort.pptx (562.951 KB)
// File Lec-3.1_Mergesort (Appendix).pptx (166.107 KB)
// File Lec-3_Mergesort.pptx (536.935 KB)
// 2. https://www.geeksforgeeks.org/sorting-by-combining-insertion-sort-and-merge-sort-algorithms/

// Progress Tracking:

// (a) Algorithm implementation: Done
// (b) Generate input data: Done but with limitation
// (c) Analyze time complexity: To be done: https://www.geeksforgeeks.org/sorting-by-combining-insertion-sort-and-merge-sort-algorithms/
// Record the number of key comparisons performed in each case.
// i. With the value of S fixed, plot the number of key comparisons over
// different sizes of the input list n. Compare your empirical results with
// your theoretical analysis of the time complexity.
// ii. With the input size n fixed, plot the number of key comparisons over
// different values of S. Compare your empirical results with your
// theoretical analysis of the time complexity.
// iii. Using different sizes of input datasets, study how to determine an
// optimal value of S for the best performance of this hybrid algorithm.
// (d) Compare with original Mergesort: Mergesort function Done

