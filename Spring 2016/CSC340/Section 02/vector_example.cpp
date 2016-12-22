#include <cstdlib>
#include <iostream>
#include <vector>
using namespace std;

int main()
{
	vector<int> v(10);
	v.push_back(10);
	
	cout << "size: " << v.size() << endl;
	int v_size = v.size();
	for (int i = 0; i < v_size; i++) {
		cout << i << ": " << v[i] << endl;
	}

	cout << "pop!" << endl;
	v.pop_back();

	cout << "size: " << v.size() << endl;

	return 0;
}

