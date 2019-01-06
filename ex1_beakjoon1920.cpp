/*-----------------------------------------
Tip."scanf" is faster than "cin";
	(for using "cin", first declare ios::sync_with_stdio(false); and cin.tie(NULL); )
	"\n" is better than using "endl";
-----------------------------------------*/

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

//int binarySearch (vector<int> v);
//int search (vector<int>v, int target, int start, int end);

int main() {
	
	std::ios::sync_with_stdio(false);	// these make cin method faster.
	cin.tie(0);					// but after using it, you cannot use <stdio.h> library input/output methods.
	
	int n, m, num, res;
	cin >> n;
	
	vector <int> v;
	
	for(int i=0; i<n ; i++)
	{
		int num;
		cin >> num;
		v.push_back(num);
	}
	sort(v.begin(), v.end());
	cin >> m;
	while(m--)
	{
		int target;
		cin >> target;
		int start = 0;
		int end = v.size()-1;
		while(1)
		{
			if(start<=end)
			{
				int mid = (start + end) /2;
				if (target == v[mid])
					{
						cout << 1 <<"\n";
						break;
					}
				else if (target < v[mid])
					{
						end = mid-1;
					}
				else
					start = mid +1; 
			}
			else
			{
				cout << 0 << "\n";
				break;
			}
		}
	}
}

//			
//int binarySearch (vector <int> v)
//{
//	int target;
//	cin >>target;
//	return search(v,target, 0, v.size()-1);
//}
//
//int search(vector <int> v, int target, int start, int end)
//{
//	int res = 0;
//	if(start<end)
//	{
//		int mid = (start+end)/2;
//		if(target<v[mid])
//			res = search(v, target, start, mid-1);
//		else if(target>v[mid])
//			res = search(v, target, mid+1, end);
//		else
//			res = 1;
//	}
//	else if(target == v[start])
//		res = 1;
//	return res; 
//}
