import time
from numpy import random
import matplotlib.pyplot as plt
import math

def insertionsort(arr):
    keyCompare = 0
    for i in range(len(arr)):
        for j in range(i,0,-1):
            keyCompare+=1
            if arr[j-1]>arr[j]:
                arr[j-1],arr[j] = arr[j],arr[j-1]
            else: break
    return keyCompare
def mergeSortT(arr,left,right,k):
    if (right-left <= k):
        return insertionsort(arr)
    mid=int((left+right)/2)
    return mergeSortT(arr,left,mid,k)+mergeSortT(arr,mid+1,right,k)+merge(arr,left,right,mid)

def mergesort_original(arr,left,right):
    if (left>=right): return 0
    mid=int((left+right)/2)
    return mergesort_original(arr,left,mid)+mergesort_original(arr,mid+1,right)+merge(arr,left,right,mid)
    
def merge(arr,left,right,mid):
    keyCompare = 0
    L = arr[left:mid+1]
    R = arr[mid+1:right+1]
    l=0; r=0
    while (l<len(L) and r<len(R)):
        keyCompare+=1
        if L[l]<R[r]:
            arr[left]=L[l]
            l+=1
        else:
            arr[left]=R[r]
            r+=1
        left+=1
    while (l<len(L)):
        arr[left]=L[l]
        left+=1
        l+=1
    while (r<len(R)):
        arr[left]=R[r]
        r+=1
        left+=1
    return keyCompare

if __name__ == "__main__":
    arr = list(random.randint(1000, size=(20)))
    mergeSortT(arr,0,len(arr)-1,2)
    print(arr)