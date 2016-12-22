#include<iostream>

/* n = # of disks, i = source, j = destination, k = spare */
void tower(int n, int i, int j, int k);
using namespace std;
int main() {
	int n;
	cout << "enter a number n : " << endl; 
	// cin >> n;
	n = 3;
	tower(n,1,3,2);
}
void tower(int n, int i, int j, int k) {
	if (n==1) { // base case
		cout << "move top disk from pole " << i << " to pole "<< j << endl;
	} else { // for n > 1
		tower(n-1,i,k,j); 
		tower(1,i,j,k); 
		tower(n-1,k,j,i);
	} 
}