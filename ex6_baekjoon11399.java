//**ATM**

package practice;

import java.util.Arrays;
import java.util.Scanner;

public class ex6_baekjoon11399 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int num = scn.nextInt();
		int[] arr = new int[num];

		for (int i = 0; i < num; i++) {
			arr[i] = scn.nextInt();
		}
		Arrays.sort(arr);

		int res = arr[0];

		for (int i = 1; i < num; i++) {
			arr[i] += arr[i - 1];
			res += arr[i];
		}
		System.out.println(res);

	}

}
