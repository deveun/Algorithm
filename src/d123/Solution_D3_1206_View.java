//단순 배열 문제
package d123;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_1206_View {
	
	public static int[] apt;
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			int num = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			apt = new int[num + 4];
			for (int i = 2; i < num + 2; i++)
				apt[i] = Integer.parseInt(st.nextToken());
			// 2번째부터 n+2번째까지 순회하면서 양옆의 가장 높은 빌딩 층을 구하고
			// 본인과의 차이를 최종값에 더하기
			int sum = 0;
			for(int i=2; i < num + 2; i++) {
				int l_max = apt[i-2] > apt[i-1] ? apt[i-2] : apt[i-1];
				int r_max = apt[i+2] > apt[i+1] ? apt[i+2] : apt[i+1];
				int max = l_max > r_max ? l_max : r_max;
				
				if(apt[i] > max)
					sum+= apt[i] - max;
			}
			System.out.println("#" + tc + " " + sum);
		}
	}
}
