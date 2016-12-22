#include <cstdlib>
#include <iostream>
using namespace std;

class Spaceship {
public:
	int numLights;
};

int main()
{
	int x = 10, y = 10;

	cout << "Enter two numbers: ";
	cin >> x >> y;

	// What happens if you enter two numbers? If you
	// enter a number and a string? A string and
	// a number?
	cout << "The second number was " << y
		 << " and the first number was " << x << "." << endl;

	// The code below is for when you want to
	// read an entire line into a string, regardless
	// of whitespace.
	/*
	string s = "";
	cout << "Enter a number: ";
	getline(cin, s);
	cout << "You entered: " << s << endl;
	*/

	return 0;
}

