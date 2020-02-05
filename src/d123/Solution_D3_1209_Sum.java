//연산
package d123;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_1209_Sum {

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			int[][] arr = new int[2][100];
			int[] cross = new int[2];
			String t = br.readLine();
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 100; j++) {
					int n = Integer.parseInt(st.nextToken());
					arr[0][i] += n;
					arr[1][j] += n;
					if (i == j)
						cross[0] += n;
					if (99 - i == j)
						cross[1] += n;
				}
			}
			Arrays.sort(arr[0]);
			Arrays.sort(arr[1]);
			Arrays.sort(cross);
			int res = Integer.max(arr[0][99], arr[1][99]);
			res = res > cross[1] ? res : cross[1];
			System.out.println("#" + tc + " " + res);
		}
	}

}
