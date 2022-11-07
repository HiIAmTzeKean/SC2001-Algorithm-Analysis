#include <stdio.h>
#include <stdlib.h>
#include <time.h> 
#define t 50
// Define threshold
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
    for (i = n+1; i <=m; i++) {
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

void merge_insertionSort (int arr[], int n, int m, long *comp, int S){
    if (m-n > S){
        int mid = n + (m - n) / 2;
        merge_insertionSort(arr, n, mid, comp, S);
        merge_insertionSort(arr, mid + 1, m, comp, S);
        merge(arr, n, mid, m, comp);
    }else{
        insertionSort(arr, n, m, comp);
    }
}

int main(){
    int *array_million, *result_c;
    float *result_t;
    array_million = (int*)malloc(1000000 * sizeof(int));
    for (int i=0; i<1000000; i++) {array_million[i]=rand();}
    result_t = (float*)malloc(101 * sizeof(float));
    result_c = (int*)malloc(101 * sizeof(int));
        // Testing merge-insertion sort
    for (int S=1; S<=100; S+=1){
        long comp = 0;
        double time_spent = 0.0;
        clock_t begin = clock();
        merge_insertionSort(array_million,0,999999, &comp, S);
        clock_t end = clock();
        printf("%d", S);
        time_spent += (double)(end - begin) / CLOCKS_PER_SEC;
        printf("The merge_insertionSort for array_million time is %f seconds\n", time_spent);
        printf("The # key comparison of merge_insertionSort for array_million time is %ld \n", comp);
        for (int i=0; i<1000000; i++) {array_million[i]=rand();}
        printf("\n");
        result_t[S] = time_spent;
        result_c[S] = comp;
    }
    for (int i=1; i<100; i++) {printf("%f, ",result_t[i]);}
    for (int i=1; i<100; i++) {printf("%d, ",result_c[i]);}
    for (int S=40; S<=50; S+=1){
        long comp = 0;
        double time_spent = 0.0;
        clock_t begin = clock();
        merge_insertionSort(array_million,0,999999, &comp, S);
        clock_t end = clock();
        printf("%d", S);
        time_spent += (double)(end - begin) / CLOCKS_PER_SEC;
        printf("The merge_insertionSort for array_million time is %f seconds\n", time_spent);
        printf("The # key comparison of merge_insertionSort for array_million time is %ld \n", comp);
        for (int i=0; i<1000000; i++) {array_million[i]=rand();}
        printf("\n");
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

