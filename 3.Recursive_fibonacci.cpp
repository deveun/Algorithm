/*------------------
Fibonacci
: f[i] = f[i-1] + f[i-2]
------------------*/
#include <iostream>
using namespace std;

int fibo(int num, int arr[]);

int main()
{
	
	std::ios::sync_with_stdio(false);
	// these disconnect stdio.h and iostream header 
	// but after using it, you cannot use <stdio.h> library at all.

	int num;	
	int arr[10000];

	cout<<"Type Number: ";
	cin>>num;
	if(num%10 == 1)
		cout<<num<<"st fibonacci is "<<fibo(num, arr)<<endl;
	else if(num%10 == 2)
		cout<<num<<"nd fibonacci is "<<fibo(num, arr)<<endl;
	else if(num%10 == 3)
		cout<<num<<"rd fibonacci is "<<fibo(num, arr)<<endl;
	else
		cout<<num<<"th fibonacci is "<<fibo(num, arr)<<endl;
	
	cout<<"{";
	for(int i=1; i<=num; i++)
	{
		cout<<arr[i];
		if(i<=num-1)
			cout<<", ";
	}
	cout<<"}";
}

int fibo(int num, int arr[]) 
{
	int result;
	if(num < 3)
		result = 1;
	else
		result = fibo(num-1, arr)+fibo(num-2, arr);
	arr[num] = result;
	return result;
}
