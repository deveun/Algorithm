/* 수도 요금 경쟁*/
package practice;

import java.util.Scanner;

public class ex14_swexpert1284 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scn = new Scanner(System.in);
		int tcase = scn.nextInt();
		
		for(int i=1; i<tcase+1; i++) {
			
			int P,Q,R,S,W = 0;
			//P = A사 1리터당 가격, 
			P=scn.nextInt();
			//Q = B사 기본요름, 
			Q=scn.nextInt();
			//R = B사 기준 리터, 
			R=scn.nextInt();
			//S = B사 추가요금,
			S=scn.nextInt();
			//W = 종민이 한달사용량 
			W=scn.nextInt();
			
			int A, B =0;
			A = W*P;
			if(W<=R)
				B = Q;
			else
				B = Q + (W-R)*S;
			
			if(A>B)
				System.out.println("#"+i+" "+B);
			else
				System.out.println("#"+i+" "+A);
			
		}
		
	}

}
