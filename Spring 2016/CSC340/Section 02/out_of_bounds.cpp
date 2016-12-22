#include <iostream>
#include <cstdlib>
using namespace std;

int main()
{
	int x[10];
	int c = 127;
	int y[10];

	for (int i = 0; i < 10; i++) {
		x[i] = i;
		y[i] = i;
	}

	cout << y[8] << endl;
	cout << y[9] << endl;
	cout << y[10] << endl;

	cout << c << endl;

	cout << x[8] << endl;
	cout << x[9] << endl;
	cout << x[10] << endl;

	cout << &c << endl;
	cout << &y[10] << endl;

	return 0;
}
