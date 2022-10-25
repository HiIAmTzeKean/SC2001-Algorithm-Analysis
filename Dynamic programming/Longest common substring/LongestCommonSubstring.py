def LCS_TopDown(str1, str2):
    arr = [[0 for i in range(len(str1)+1)] for i in range (len(str2)+1)]
    hint = [[0 for i in range(len(str1)+1)] for i in range (len(str2)+1)]
    for i in range (0,len(str1)+1):
        hint[0][i] = "|"
    for i in range (1,len(str2)+1):
        hint[i][0] = "-"
    LCS_TopDownHelper(str1, str2, arr, hint)
    print(arr)
    print(hint)
    
def LCS_TopDownHelper(str1, str2, arr, hint):
    if len(str1)==0 or len(str2)==0:
        arr[len(str2)][len(str1)] = 0
        hint[len(str2)][len(str1)] = "|"
        return 0;
    largest = 0
    
    if (str1[-1] == str2[-1]):
        largest = LCS_TopDownHelper(str1[0:-1], str2[0:-1], arr, hint) + 1
        hint[len(str2)][len(str1)] = "\\"
    elif (LCS_TopDownHelper(str1, str2[0:-1], arr, hint)>=LCS_TopDownHelper(str1[0:-1], str2, arr, hint)):
        largest = LCS_TopDownHelper(str1, str2[0:-1], arr, hint)
        hint[len(str2)][len(str1)] = "|"
    else:
        largest = LCS_TopDownHelper(str1[0:-1], str2, arr, hint)
        hint[len(str2)][len(str1)] = "-"
    arr[len(str2)][len(str1)] = largest
    return largest

def LCS_BottomUp(str1, str2):
    # create array to store
    arr = [[0 for i in range(len(str1)+1)] for i in range (len(str2)+1)]
    hint = [[0 for i in range(len(str1)+1)] for i in range (len(str2)+1)]
    
    for i in range (0,len(str1)+1):
        hint[0][i] = "|"
    for i in range (1,len(str2)+1):
        hint[i][0] = "-"
        
    for i in range (1,len(str2)+1):
        for j in range (1,len(str1)+1):
            if (str1[j-1]==str2[i-1]):
                # diagonal
                arr[i][j] = arr[i-1][j-1] + 1
                hint[i][j] = "\\"
            elif (arr[i-1][j]>=arr[i][j-1]):
                arr[i][j] = arr[i-1][j]
                hint[i][j] = "|"
            else:
                arr[i][j] = arr[i][j-1]
                hint[i][j] = "-"
    print(arr)
    print(hint)
LCS_TopDown("ABCDE", "ACCD")
    