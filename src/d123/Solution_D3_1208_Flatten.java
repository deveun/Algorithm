//배열, 정렬
package d123;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_1208_Flatten {
	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			int num = Integer.parseInt(br.readLine());
			int[] arr = new int[100];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < 100; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			// 평탄화
			int res = Integer.MAX_VALUE;
			while (num-- >= 0) {
				Arrays.sort(arr);
				int min = arr[0];
				int max = arr[99];
				res = max - min;

				if (min == max) {
					res = num % 2 == 0 ? 0 : 1;
					break;
				}
				arr[0]++;
				arr[99]--;
			}
			System.out.println("#" + tc + " " + res);
		}
	}
}