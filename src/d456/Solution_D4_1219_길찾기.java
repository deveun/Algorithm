//dfs
package d456;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_D4_1219_길찾기 {

	public static int res;
	public static Stack<Integer>[] num;

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String t = st.nextToken();
			int pair = Integer.parseInt(st.nextToken());
			num = new Stack[100];
			for (int i = 0; i < 100; i++)
				num[i] = new Stack<Integer>();
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < pair; i++) {
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				num[s].add(e);
			}

			res = 0;
			dfs(0);
			System.out.println("#" + tc + " " + res);
		}
	}

	public static void dfs(int sta) {

		if (sta == 99) {
			res = 1;
			return;
		}

		while (!num[sta].empty())
			dfs(num[sta].pop());
	}

}