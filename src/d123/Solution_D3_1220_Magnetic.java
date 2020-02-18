//시뮬 (규칙)
package d123;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_1220_Magnetic {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			int size = Integer.parseInt(br.readLine());
			int[][] arr = new int[size][size];

			for (int i = 0; i < size; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < size; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int res = 0;
			for (int i = 0; i < size; i++) {
				boolean N = false;
				for (int j = 0; j < size; j++) {
					if (arr[j][i] == 1)
						N = true;
					else if (N && arr[j][i] == 2) {
						N = false;
						res++;
					}
				}
			}

			System.out.println("#" + tc + " " + res);

		}
	}

}