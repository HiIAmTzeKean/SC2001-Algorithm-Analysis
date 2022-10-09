import math

def quicksort(arr, start, end):
    if (start==end):
        return
    mid = math.floor((start + end)/2)
    newMid = partition(arr, mid, start, end)
    quicksort(arr, start, newMid-1)
    quicksort(arr, newMid+1, end)

    
def partition(arr, mid, start, end):
    # swap mid to first
    temp = arr[start]
    arr[start] = arr[mid]
    arr[mid] = temp
    
    lastSmall = start
    # start the comparison
    for i in range(start+1, end+1):
        # check if target larger than pivot
        # if larger, shift large pointer
        if (arr[i]>=arr[start]):
            continue
        # if smaller, swap
        else:
            lastSmall+=1
            temp = arr[lastSmall]
            arr[lastSmall] = arr[i]
            arr[i] = temp
    # put mid back
    temp = arr[start]
    arr[start] = arr[lastSmall]
    arr[lastSmall] = temp
    return lastSmall
    
if __name__ == "__main__":
    arr = [5,4,2,1,3]
    quicksort(arr, 0,4)
    print(arr)