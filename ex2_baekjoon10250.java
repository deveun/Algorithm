package practice;

//ACMÈ£ÅÚ
import java.util.Scanner;

public class ex2_baekjoon10250 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int test = scn.nextInt();
		while(test-- > 0)
		{
			int h = scn.nextInt();
			int w = scn.nextInt();
			int n = scn.nextInt();
			int result_h, result_w;
		
			result_h= n%h;
			result_w= (n-result_h)/h+1;
			if (result_h == 0) {
				result_h = h;
				result_w -=1;
			}
			System.out.format("%d%02d%n",result_h,result_w);
		}
	}

}
