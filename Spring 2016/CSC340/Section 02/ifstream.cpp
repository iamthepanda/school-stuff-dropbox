#include <iostream>
#include <fstream>
using namespace std;

int main()
{
	ifstream inputFile("file.txt");
	int x;

	while (true) {
		inputFile >> x;
		if (inputFile.fail()) {
			break;
		}
		cout << "Next number: " << x << endl;
	}

	return 0;
}

