//배열
package d123;

import java.io.*;
import java.util.*;

public class Solution_D3_1225_암호생성기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			br.readLine();
			int[] arr = new int[8];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < 8; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				min = Integer.min(arr[i], min);
			}
			int mod = min / 15;
			for (int i = 0; i < 8; i++)
				arr[i] -= (mod - 1) * 15;

			// 한 칸 씩 움직이기
			int num = 0;
			while (true) {
				num = num % 5 + 1;
				int tmp = arr[0] > num ? arr[0] - num : 0;
				for (int i = 1; i < 8; i++)
					arr[i - 1] = arr[i];
				arr[7] = tmp;
				if (arr[7] == 0)
					break;
			}
			StringBuilder sb = new StringBuilder("#" + tc + " ");
			for (int a : arr)
				sb.append(a + " ");
			System.out.println(sb);

			// 바퀴마다 변하는 값을 체크
			/*
			 * int pvt = 0; loop: for (int i = 0; i < Integer.MAX_VALUE; i++) { for (int j =
			 * 0; j < 8; j++) { arr[j] -= (i * 8 + j) % 5 + 1; if (arr[j] <= 0) { arr[j] =
			 * 0; pvt = j; break loop; } } }
			 * 
			 * StringBuilder sb = new StringBuilder("#" + tc + " "); for (int i = pvt + 1; i
			 * < 8; i++) sb.append(arr[i] + " "); for (int i = 0; i < pvt + 1; i++)
			 * sb.append(arr[i] + " "); System.out.println(sb);
			 */
		}
	}
}