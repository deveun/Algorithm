#include <iostream>
#include <conio.h>

using namespace std;

void Bubblesort(int arr[], int num);
void Insertionsort(int arr[], int num);
void Mergesort(int arr[], int num);
void Merge(int arr[], int start, int end);

int main() {
		
	while(1)
	{
		int num;
	
		cout<<"Type array that you want to sort. (ex) 1 5 4 2 6)"<<endl;
		cout<<"Number of Array: ";
		cin>>num;
	
		int arr[num];
		cout<<"Array: ";
	
		for(int i = 0; i<num; i++)
		{
			cin>>arr[i];	
		}

		cout<<"--------------------------------"<<endl;
		cout<<"-------Select Sort Method-------"<<endl;
		cout<<"-- 1. Bubble Sort             --"<<endl;
		cout<<"-- 2. Insertion Sort          --"<<endl;
		cout<<"-- 3. Merge Sort              --"<<endl;
		cout<<"--------------------------------"<<endl;
		int method = getch();
		switch(method-48)
		{
			case 1:
				Bubblesort(arr, num);
				break;
			case 2:
				Insertionsort(arr, num);
				break;
			case 3:
				Mergesort(arr, num);
				break;
			default:
				cout<<"Try Again."<<endl;
				break;			
		}
		cout<<endl<<endl;
	}
}




/*i와 i+1을 비교, 클 경우 둘을 교체하고 다시 i+1과 i+2를 비교.
이런식으로 가장 큰 값을 배열의 오른쪽에 위치하게 하면서 정렬.*/ 
void Bubblesort(int arr[], int num)
{
	int tmp;
	
	for(int j=0; j<num-1;j++)
	{
		for(int i=0; i<num-1-j; i++)
		{
			if(arr[i]>arr[i+1])
			{
			tmp = arr[i];
			arr[i] = arr[i+1];
			arr[i+1] = tmp;
			}
		}
	}
	cout<<"Result Array: "; 
	for(int i=0; i<num; i++)
	cout<<arr[i]<<" ";
}	

/*첫번쨰 값부터 정렬.
정렬된 배열의 다음 숫자를 앞의 값과 비교하며, 적절한 위치에 Insert */ 
void Insertionsort(int arr[], int num)
{
	int tmp;
	
	for(int j=1; j<num; j++)
	{
		for(int i=j; i>0; i--)
		{
			if(arr[i-1]>arr[i])
			{
				tmp = arr[i];
				arr[i] = arr[i-1];
				arr[i-1] = tmp;
			}
			else
				break;
		}
	}
	cout<<"Result Array: "; 
	for(int i=0; i<num; i++)
	cout<<arr[i]<<" ";
}	

/*Merge 함수를 재귀로 함께 사용.
 배열을 두개의 구간으로 나누고, tmp 배열에 각 구간에서 작은 숫자를 입력, x or y 포인터를
 한 칸씩 이동하는 방식으로 정렬한 뒤, 다시 arr배열에 정렬된 값을 넣어줌.*/
void Mergesort(int arr[], int num)
{
	Merge(arr, 0, num-1);
	
	cout<<"Result Array: "; 
	for(int i=0; i<num; i++)
	cout<<arr[i]<<" ";

}
void Merge(int arr[], int start, int end)
{
	int mid = (start+end)/2;
	
	if(start<end)
	{
	Merge(arr,start,mid);
	Merge(arr,mid+1,end);
	}

	int x = start;
	int y = mid+1;
	int index = 0;
	int tmp[end-start+1];
	
	while (x <= mid && y <= end) {
        if (arr[x] <= arr[y]) 
            tmp[index++] = arr[x++];
        else
            tmp[index++] = arr[y++];
    }
 
    while (x <= mid)
        tmp[index++] = arr[x++];
    while (y <= end)
        tmp[index++] = arr[y++];
 
 	int t = 0;
    for (int i = start; i <= end; i++) {
        arr[i] = tmp[t++];
    } 
}


