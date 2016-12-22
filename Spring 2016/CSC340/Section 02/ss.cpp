#include <cstdlib>
#include <iostream>
#include <sstream>
using namespace std;

int main()
{
	string line;
	stringstream ss;
	int x = 0, y = 0, z = 0;
	
	cout << "Give me some numbers: ";
	getline(cin, line);

	ss << line;
	ss >> x >> y >> z;

	cout << "The sum is " << (x + y + z) << endl;
	cout << "The original line was " << line << endl;

	return 0;
}

