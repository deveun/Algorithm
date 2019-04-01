//**º¸¹°**

package practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ex8_baekjoon1026 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		
		int[] arr1 = new int[N];
		Integer[] arr2 = new Integer[N];
		
		for(int i=0; i< N; i++)
			arr1[i]=scn.nextInt();
		for(int i=0; i< N; i++)
			arr2[i]=scn.nextInt();
		
		Arrays.sort(arr1);
		Arrays.sort(arr2, Collections.reverseOrder());
		int res=0;
		for(int i=0;i<N;i++)
			res+=arr1[i]*arr2[i];
		
		System.out.println(res);
	}

}
