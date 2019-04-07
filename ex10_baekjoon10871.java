//**X보다 작은 수**
package practice;

import java.util.ArrayList;
import java.util.Scanner;

public class ex10_baekjoon10871 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		int X = scn.nextInt();
		int[] arr = new int[N];
		ArrayList<Integer> small = new ArrayList<Integer>();

		for (int i = 0; i < N; i++)
			arr[i] = scn.nextInt();

		for (int i = 0; i < N; i++) {
			if (arr[i] < X)
				small.add(arr[i]);
		}
		for (int i = 0; i < small.size(); i++) {
			System.out.print(small.get(i)+" ");
		}
	}

}
