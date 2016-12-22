#include <cstdlib>
#include <iostream>
#include <vector>
#include <sstream>
using namespace std;

int vector_sum(vector<int> &nums)
{
	int sum = 0;
	for (int i = 0; i < nums.size(); i++) {
		sum += nums[i];
	}

	return sum;
}

int main()
{
	vector<int> nums;
	stringstream ss;
	string temp;

	cout << "Give me some numbers: ";
	getline(cin, temp);
	ss << temp;

	while (true) {
		int next_num;
		ss >> next_num;

		if (ss.fail()) break;

		nums.push_back(next_num);
	}

	cout << "The sum is " << vector_sum(nums) << endl;

	return 0;
}

