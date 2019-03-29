//**Dynamic Programming (동적계획법)
//재귀로 계속 반복되는 값을 구하지 않도록 Memorizing 하기.
//Bottom-up 방식으로 첫번째부터 구하면서 값 저장하기.
//ex)피보나치, 이항계수 같은 다음 값을 구하기 위해 이전 값을 알아야 하는 경우에 사용.

//**이항계수 (Binomial Coefficient)
//nCm == n개 중에서 m개를 선택하는 경우의 수
//== (n-1Cm) + (n-1Cm-1) 의 공식으로 구할 수 있음.
package practice;

import java.util.Scanner;

public class DynamicProgramming {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n, m;
		int[][] res = new int[101][101];
		System.out.print("Type n,m: ");
		n = scn.nextInt();
		m = scn.nextInt();
		
		res[1][1] = 1;

		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				if (j == 1)
					res[i][j] = i;
				else if( i == j)
					res[i][j] = 1;
				else
					res[i][j] = res[i-1][j] + res[i-1][j-1];
			}
		}

		System.out.println(n + "C" + m + " = " + res[n][m]);
	}

}
