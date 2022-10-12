#include <bits/stdc++.h>
using namespace std;

int knapsack(int W, int wt[], int val[], int n){
	if (n==0 || W==0)
		return 0;

	if (wt[n-1]>W)
		return knapsack(W,wt,val,n-1);
	else
		return max(knapsack(W,wt,val,n-1),val[n-1]+knapsack(W-wt[n-1],wt,val,n-1));
}

int main(){
	int val[] = {7, 6, 9};
	int wt[] = { 4, 6, 8};
	int W = 14;
	int n = 3;
	cout << knapsack(W,wt,val,n) << endl;
}