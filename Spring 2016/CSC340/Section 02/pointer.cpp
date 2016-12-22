#include <cstdlib>
#include <iostream>
using namespace std;

int main()
{
	int x = 16;
	int* y = &x;

	cout << x << endl;
	cout << y << endl;
	cout << *y << endl;

	return 0;
}

