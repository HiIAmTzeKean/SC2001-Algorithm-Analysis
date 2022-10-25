def knapsack(C,p,w,W):
    # Base case
    if (W<0): return 0
    
    # Init variables
    notTaken=taken=takenRepeated=0
    
    # Recursive definition
    notTaken = knapsack(C,p,w,W-1)+0 # Not taken
    if (C-w[W]>=0):
        taken = knapsack(C-w[W],p,w,W-1)+p[W] # Taken and not repeated
        takenRepeated = knapsack(C-w[W],p,w,W)+p[W] # Taken and repeated
    
    # Compare which solution is optimal
    if (notTaken>taken and notTaken>takenRepeated):
        return notTaken
    elif (taken>notTaken and taken>takenRepeated):
        return taken
    else:
        return takenRepeated  

def knapsackSimple(C,p,w,W):
    # Base case
    if (W<0): return 0
    # Recursive definition
    return max(knapsackSimple(C,p,w,W-1)+0, # not taken
            knapsackSimple(C-w[W],p,w,W-1)+p[W] if C-w[W]>=0 else 0, # taken and do not repeat
            knapsackSimple(C-w[W],p,w,W)+p[W] if C-w[W]>=0 else 0) # taken and try repeated take

if __name__ == "__main__":
    p = [7,6,9]
    w = [4,6,8]
    print(knapsackSimple(14,p,w,len(w)-1))