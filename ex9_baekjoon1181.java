//**단어정렬**
package practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ex9_baekjoon1181 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		String[] str = new String[N];

		for (int i = 0; i < N; i++) {
			str[i] = scn.next();
		}

		Arrays.sort(str);
		Arrays.sort(str, new Comparator<String>() {
			@Override
			public int compare(String str1, String str2) {
				if (str1.length() < str2.length())
					return -1;
				else if (str1.length() > str2.length())
					return 1;
				else
					return 0;
			}
		});

		System.out.println(str[0]);
		for (int i = 1; i < N; i++) {
			if (!str[i - 1].equals(str[i]))
				System.out.println(str[i]);
		}
	}
}
