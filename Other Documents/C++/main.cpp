#include <iostream>
#include <stdio.h> // use <cstdio> for newer compilers.
using namespace std;

int main()
{
	// a pointer to char is initialized with a string literal
	char *Buffer = "Dummy content.";
	
	cout << "Original content of Buffer:--> " << Buffer << endl;
	cout << "Enter a sentense: " << endl;

	// use gets() to get the whole line.
	// cout would only get the first word.
	gets(Buffer);
	cout << "Now the Buffer contains:--> " << endl;
	cout << Buffer << endl;
	return 0;
}
