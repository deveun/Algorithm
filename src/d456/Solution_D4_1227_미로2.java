package d456;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_D4_1227_미로2 {
	public static int[] di = new int[] { -1, 0, 1, 0 };
	public static int[] dj = new int[] { 0, 1, 0, -1 };
	public static int res;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			br.readLine();
			char[][] arr = new char[100][100];
			int[] sta = new int[2];
			for (int i = 0; i < 100; i++) {
				String str = br.readLine();
				for (int j = 0; j < 100; j++) {
					arr[i][j] = str.charAt(j);
					if (arr[i][j] == '2') {
						sta[0] = i;
						sta[1] = j;
					}
				}
			}

			res = 0;
			dfs(sta[0], sta[1], arr);
			System.out.println("#" + tc + " " + res);
		}
	}

	public static void dfs(int i, int j, char[][] arr) {

		if (arr[i][j] == '3') {
			res = 1;
			return;
		}

		arr[i][j] = '1';
		for (int dir = 0; dir < 4; dir++) {
			int ni = i + di[dir];
			int nj = j + dj[dir];
			if (ni >= 0 && ni < 100 && nj >= 0 && nj < 100 && arr[ni][nj] != '1')
				dfs(ni, nj, arr);
			// arr[i][j] = 0;
		}
	}
}