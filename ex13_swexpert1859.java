/* 백만 장자 프로젝트
 * : 주어진 날짜동안 물건의 매매로 이익이 최대가 되도록 하기
 * TIP. 결과값(res)은 long타입으로 선언
 * TIP. 배열의 마지막부터 계산을 시작하면 쉽다!
 * */


package practice;

import java.util.Scanner;

public class ex13_swexpert1859 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);
		int tcase = scn.nextInt();

		//input data
		for (int j = 0; j < tcase; j++) {
			int days = scn.nextInt();
			int[] arr = new int[1000001];
			for (int i = 0; i < days; i++)
				arr[i] = scn.nextInt();

			long res = invest(arr, days-1);
			System.out.println("#" + (j + 1) + " " + res);
		}
	}

	//배열의 뒷부분부터 시작, 앞의 가격보다 높을 때 이익을 계산.
	//가격이 떨어진 경우 높은 가격 index 기준으로 다시 앞의 배열 재귀.
	static long invest(int[] arr, int start) {
		int sellday = start;
		int sell = arr[start];
		long res = 0;
		
		for(int i=start; i>=0; i--) {
			if(arr[i]<=sell)
				res += (sell-arr[i]);
			else {
				sell = arr[i];
				sellday = i;
				break;
			}
			if(i==0)
				return res;
		}
		
		res+=invest(arr, sellday);
		return res;
	}
}
