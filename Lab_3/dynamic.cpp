#include <bits/stdc++.h>
using namespace std;

int knapsack(int W, int wt[], int val[], int n){
	vector <int> ans(W+1,0);
	
	for (int i=1; i<=n; i++){
		for (int w=W; w>=0; w--){
			if (wt[i-1]<=w){
				ans.at(w) = max(ans.at(w), ans.at(w-wt[i-1])+val[i-1]);
			}		
		}		
	}
	return ans.at(W);
}

int main(){
	int val[] = {7, 6, 9};
	int wt[] = { 4, 6, 8};
	int W = 14;
	int n = 3;
	int val1[] = {7, 6, 9};
	int wt1[] = { 5, 6, 8};
	cout << knapsack(W,wt,val,n) << endl;
	cout << knapsack(W,wt1,val1,n) << endl;
}