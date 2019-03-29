//** 1만들기 **
//DYNAMIC PROGRAMMING : Bottom-up 방식으로 개발
//min() 함수 사용하기.
//RUNTIME ERROR :: new int[num];으로 작성하면 num이 3보다 작을 때, 값을 할당할 수 없다.
package practice;

import java.util.Scanner;
import java.math.*;

public class ex4_baekjoon1463 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int num = scn.nextInt();
		int[] res = new int[1000001];
		
		res[1]=0;
		res[2]=1;
		res[3]=1;
		for(int i=4; i<=num; i++) {
			res[i]=res[i-1]+1;
			if(i%3 == 0)
				res[i] = Math.min(res[i],res[i/3]+1);
			if(i%2 == 0)
				res[i] = Math.min(res[i],res[i/2]+1);
		}
		System.out.println(res[num]);
	}
}
