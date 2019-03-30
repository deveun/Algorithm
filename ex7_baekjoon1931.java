//** 회의실 배정 **
//그리디 알고리즘 (Greedy Algorithm)
//https://blog.naver.com/sochun1518/221483271822
//문제를 해결하는 아이디어가 중요!!!
//--> 회의실 사용 시간을 끝나는 시간 순서로 정렬하는 것이 필요!

package practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ex7_baekjoon1931 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int test = scn.nextInt();
		int[][] arr = new int[test][2];

		for (int i = 0; i < test; i++) {
			arr[i][0] = scn.nextInt();
			arr[i][1] = scn.nextInt();
		}
		
		//!!2차원 배열 정렬방법!!
		Arrays.sort(arr,new Comparator<int[]>() {
			@Override
			public int compare(final int[] array1, final int[] array2) {
				final Integer num1 = array1[0];
				final Integer num2 = array2[0];
				return Integer.compare(num1,  num2);
			}
		});
		
		Arrays.sort(arr,new Comparator<int[]>() {
			@Override
			public int compare(final int[] array1, final int[] array2) {
				final Integer num1 = array1[1];
				final Integer num2 = array2[1];
				return Integer.compare(num1,  num2);
			}
		});
		
		int res = 1;
		int check_e = arr[0][1];
		for(int i=1; i< test; i++)
		{
			if(arr[i][0] >= check_e)
			{
				check_e = arr[i][1];
				res ++;
			}
		}
		
		System.out.println(res);
	}
}
