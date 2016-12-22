#include <cstdlib>
#include <iostream>
using namespace std;

struct Student
{
	string name;
	int age;
	string yearInSchool;
};

void someFunction(Student s)
{
	s.name = "George Clooney";
	s.age = 0;
	cout << "name: " << s.name << ", age: " << s.age
		 << ", year in school: " << s.yearInSchool << endl;
}

int main()
{
	Student me;
	me.name = "Jonathan";
	me.age = 100;
	me.yearInSchool = "what is school?";

	cout << "name: " << me.name << ", age: " << me.age
		 << ", year in school: " << me.yearInSchool << endl;
	
	someFunction(me);

	cout << "name: " << me.name << ", age: " << me.age
		 << ", year in school: " << me.yearInSchool << endl;

	return 0;
}

