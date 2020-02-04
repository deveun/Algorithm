// 카운팅 배열 활용
package d123;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_1204_최빈수구하기 {
	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			String tt = br.readLine();
			int cnt = 0;
			int[] score = new int[101];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 1000; i++) {
				int s = Integer.parseInt(st.nextToken());
				score[s]++;
				cnt = score[s] > cnt ? score[s] : cnt;
			}

			for (int i = 100; i >= 0; i--) {
				if (score[i] == cnt) {
					System.out.println("#" + t + " " + i);
					break;
				}
			}
		}
	}
}