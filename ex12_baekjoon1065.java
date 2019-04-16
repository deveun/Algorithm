//**한수**
//숫자의 각 자리값이 등차수열
//브루트포스

package practice;

import java.util.Scanner;

public class ex12_baekjoon1065 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int num = scn.nextInt();
		int res = 99;

		if (num < 100)
			res = num;
		else if (num == 1000)
			res += (5 * 9);
		else {
			res += 5 * (num / 100 - 1);
			for (int j = num / 100 * 100; j <= num; j++) {
				int[] n = new int[3];
				n[0] = Character.getNumericValue(String.valueOf(j).charAt(0));
				n[1] = Character.getNumericValue(String.valueOf(j).charAt(1));
				n[2] = Character.getNumericValue(String.valueOf(j).charAt(2));
				if (n[0] - n[1] == n[1] - n[2])
					res++;
			}
		}
		System.out.println(res);
	}

}
