#include <iostream>
using namespace std;

int fac(int num);

int main()
{
	
	std::ios::sync_with_stdio(false);
	// these disconnect stdio.h and iostream header 
	// but after using it, you cannot use <stdio.h> library at all.

	int num;	
	cout<<"Type Number: ";
	cin>>num;
	cout<<"Result: "<<num<<"! = "<<fac(num);
}

int fac(int num) 
{
	if(num == 1)
		return 1;
	else
		return fac(num-1) * num;
}
