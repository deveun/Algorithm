//**1, 2, 3 더하기 **
//동적계획법 사용
//!점화식을 찾아내는 것이 중요.

package practice;

import java.util.Scanner;

public class ex5_baekjoon9095 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int test = scn.nextInt();
		while(test-- > 0)
		{
			int num = scn.nextInt();
			int[] res = new int[12];
			res[1] = 1;
			res[2] = 2;
			res[3] = 4;
			
			for(int i=4; i<12; i++)
				res[i] = res[i-1] + res[i-2] + res[i-3];
			
			System.out.println(res[num]);
		}
	}

}
