#include <iostream>
#include <conio.h>
/*배열 대신 Vector사용*/ 
#include <vector> 

using namespace std;

int Linearsearch(vector<int> v, int target);
int Binarysearch(vector<int> v, int target);
int Search(vector<int> v, int target, int size, int end);

int main() {
	
	while(1) {	
	int num;
	cout<<"Type nymber of array"<<endl<<"(It must be sorted to conduct Binery Search): ";
	cin>>num;
	
	vector<int> v;
	cout<<"Type array: ";
	for(int i=0; i<num; i++)
	{
		int a;
		cin>>a;
		v.push_back(a);
	}
	int target;	
	cout<<"Type a number that you want to find: ";
	cin>>target;
	
	cout<<endl<<"--------Select Selection Menu--------"<<endl;
	cout<<"--        1. Linear Search         --"<<endl;
	cout<<"--        2. Binery Search         --"<<endl;
	cout<<"--        0. Finish Program        --"<<endl;
	cout<<"-------------------------------------"<<endl;
	int method = getch();
	int result = -1;
	
	switch(method-48) {
		case 1:
			result=Linearsearch(v, target);
			break;
		case 2:
			result=Binarysearch(v, target);
			break;
		case 0:
			return 0;
		default:
			break;
	}
	
	if(result!=-1)
		cout<<"arr["<<result<<"] = "<<target<<endl<<endl;
	else
		cout<<"There is no \""<<target<<"\" in the array."<<endl;
	}
}

/* 배열의 처음부터 끝까지 차례대로 비교하며 찾기*/ 
int Linearsearch(vector<int> v, int target)
{
	int size = v.size(); 
	for(int i=0; i<size; i++)
		if(target == v[i])
			return i;
	return -1;
}

int Binarysearch(vector<int> v, int target)
{	
	return Search(v, target, 0, v.size()-1);
}

/*배열의 mid값과 target을 비교하여 더 작으면 앞구간 탐색/
더 크면 뒷 구간을 탐색. */ 
int Search(vector<int> v, int target, int start, int end) 
{
	int result=-1;
	if(start<end) {
		int mid = (start+end)/2;
		if(target<v[mid])
			result=Search(v, target, start, mid-1);
		else if(target>v[mid])
			result=Search(v, target, mid+1, end);
		else
			result=mid;
	}
	else if (v[start]==target)
	 return start;
	
	return result;
}	
