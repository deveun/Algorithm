//**30**
//30의 배수인지 알아내기
//3의 배수조건 - 모든 자리 수의 합이 3의 배수.

package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ex11_baekjoon10610 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String num = scn.next();

		ArrayList<Integer> arr = new ArrayList<>();

		// ArrayList에 자리 값 저장
		for(int i=0; i<num.length();i++) {
			arr.add(Character.getNumericValue(num.charAt(i)));
		}

		// 모든 자리의 값을 더해줌.
		int sum = 0;
		int zero = 0;
		for (int n : arr) {
			sum += n;
			if (n == 0)
				zero = 1;
		}

		// 더한 값이 3의 배수인지, 맨뒷자리에 0이 있는지 확인
		// Collections를 활용해 정렬 / 내림차순
		if (zero == 1 && sum % 3 == 0) {
			Collections.sort(arr);
			Collections.reverse(arr);
			for(int n: arr)
				System.out.print(n);
		}
		else {
			System.out.println(-1);
		}

	}
}
