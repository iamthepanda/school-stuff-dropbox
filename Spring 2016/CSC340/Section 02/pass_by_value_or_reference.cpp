#include <cstdlib>
#include <iostream>
#include <vector>
using namespace std;

struct MyStruct
{
	MyStruct() {
		v1.reserve(1000);
		v2.reserve(1000);
		v3.reserve(1000);
	}

	vector<int> v1, v2, v3;
};

// If you pass s by reference, this function is fast.
// If you pass it by value, it is slow.
void my_function(MyStruct &s) {
	// do nothing
}

int main()
{
	MyStruct s;
	for (int i = 0; i < 100000000; i++) {
		my_function(s);
	}

	return 0;
}

