// 간단시뮬
package d123;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_1210_Ladder1 {

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			String t = br.readLine();
			int[][] arr = new int[100][100];
			int dest = -1;
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (arr[i][j] == 2)
						dest = j;
				}
			}
			// dest부터 타고 올라가기
			int h = 99;
			while (h-- > 0) {
				if (dest > 0 && arr[h][dest - 1] == 1) {
					while (dest > 0 && arr[h][dest - 1] == 1)
						dest--;
				} else if (dest < 99 && arr[h][dest + 1] == 1) {
					while (dest < 99 && arr[h][dest + 1] == 1)
						dest++;
				}
			}

			System.out.println("#" + tc + " " + dest);

		}
	}

}
