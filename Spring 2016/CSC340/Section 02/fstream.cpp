#include <iostream>
#include <fstream>
#include <vector>
#include <string>
using namespace std;

string formatForFile(int nextNumber)
{
	if (nextNumber >= 10) {
		return to_string(nextNumber);
	} else {
		return "0" + to_string(nextNumber);
	}
}

int main()
{
	fstream fileOfNumbers("file.txt");
	int x;
	vector<int> vectorOfNumbers;

	while (true) {
		fileOfNumbers >> x;
		if (fileOfNumbers.fail()) {
			break;
		}

		vectorOfNumbers.push_back(x);
	}

	fileOfNumbers.clear();
	fileOfNumbers.seekp(0);
	
	for (int next : vectorOfNumbers) {
		cout << "next num in vector: " << next << endl;
		cout << "write cursor: " << fileOfNumbers.tellp() << endl;
		string nextString = formatForFile(next + 1);
		fileOfNumbers << nextString << endl;
	}

	fileOfNumbers.close();

	return 0;
}

