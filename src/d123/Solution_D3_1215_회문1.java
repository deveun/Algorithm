//StringBuilder reverse함수 사용
package d123;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_D3_1215_회문1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			int len = Integer.parseInt(br.readLine());
			char[][] arr = new char[8][8];
			for (int i = 0; i < 8; i++)
				arr[i] = br.readLine().toCharArray();

			int res = 0;
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					StringBuilder garo = new StringBuilder();
					StringBuilder sero = new StringBuilder();
					for (int k = 0; k < len; k++) {
						if (i + k < 8)
							sero.append(arr[i + k][j]);
						if (j + k < 8)
							garo.append(arr[i][j + k]);
					}
					if (garo.length() == len && garo.toString().equals(garo.reverse().toString())) {
						res++;
					}
					if (sero.length() == len && sero.toString().equals(sero.reverse().toString())) {
						res++;
					}
				}
			}
			System.out.println("#" + t + " " + res);
		}
	}
}