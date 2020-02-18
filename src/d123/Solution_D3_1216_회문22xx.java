package d123;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_D3_1216_회문22xx {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			String tc = br.readLine();
			String[][] s = new String[100][2];

			// 가로와 세로 String값을 배열에 저장
			for (int i = 0; i < 100; i++) {
				String str = br.readLine();
				s[i][0] = str;
				for (int j = 0; j < 100; j++)
					s[j][1] += str.charAt(j);

			}

			int len = 100;
			loop: while (len-- > 0) {
				for (int i = 0; i < 2; i++) {
					for (int j = 0; j < 100; j++) {
						kk: for (int k = 0; k < 100; k++) {
							for (int l = 0; l < len / 2; l++) {
								if (k + len - 1 >= 100 || (s[j][i].charAt(k + l) != s[j][i].charAt(k + len - 1 - l)))
									continue kk;
								if (l == len / 2 - 1)
									break loop;
							}
						}
					}
				}
			}
			System.out.println("#" + t + " " + len);
		}
	}

}