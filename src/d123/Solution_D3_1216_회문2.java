// 반복문, StringBuilder reverse
// (효율성 낮음)
package d123;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_D3_1216_회문2 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			String tc = br.readLine();
			String[][] s = new String[100][2];

			// 가로와 세로 String값을 배열에 저장
			for (int i = 0; i < 100; i++) {
				String str = br.readLine();
				for (int j = 0; j < 100; j++) {
					s[i][0] += str.charAt(j);
					s[j][1] += str.charAt(j);
				}
			}

			int len = 100;
			loop: while (len-- > 0) {
				for (int i = 0; i < 2; i++) {
					for (int j = 0; j < 100; j++) {
						for (int k = 0; k < 100 - len + 1; k++) {
							String sub = s[j][i].substring(k, k + len);
							if (sub.equals(new StringBuilder(sub).reverse().toString()))
								break loop;
						}
					}
				}
			}
			System.out.println("#" + t + " " + len);

		}
	}

}