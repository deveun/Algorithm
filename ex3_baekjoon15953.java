package practice;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

public class ex3_baekjoon15953 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<Integer, Integer> prize17 = new LinkedHashMap();
		prize17.put(1, 5000000);
		prize17.put(3, 3000000);
		prize17.put(6, 2000000);
		prize17.put(10, 500000);
		prize17.put(15, 300000);
		prize17.put(21, 100000);

		Map<Integer, Integer> prize18 = new LinkedHashMap();
		prize18.put(1, 5120000);
		prize18.put(3, 2560000);
		prize18.put(7, 1280000);
		prize18.put(15, 640000);
		prize18.put(31, 320000);

		Scanner scn = new Scanner(System.in);
		int test = scn.nextInt();
		while (test-- > 0) {
			int n17 = scn.nextInt();
			int n18 = scn.nextInt();
			int total = 0;

			if (0 < n17 && n17 < 22)
				for (int key : prize17.keySet()) {
					if (n17 <= key) {
						total += prize17.get(key);
						break;
					}
				}
			if (0 < n18 && n18 < 32)
				for(int key : prize18.keySet()) {
					if(n18 <= key) {
						total += prize18.get(key);
						break;
					}
				}
			System.out.println(total);
		}
	}

}
