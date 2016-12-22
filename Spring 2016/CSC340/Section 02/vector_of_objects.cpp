#include <cstdlib>
#include <iostream>
#include <vector>
using namespace std;

class Spaceship
{
private:
	int numLights;

public:
	Spaceship(int numLights)
	{
		this->numLights = numLights;
	}

	Spaceship()
	{
		this->numLights = 5;
	}

	int getNumLights()
	{
		return this->numLights;
	}
};

int main()
{
	vector<Spaceship> v(10);

	for (int i = 0; i < v.size(); i++) {
		cout << "spaceship " << (i + 1) << " has "
				 << v[i].getNumLights() << " lights." << endl;
	}

	return 0;
}

