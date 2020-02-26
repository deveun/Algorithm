// 후위연산
package d456;

import java.io.*;
import java.util.*;

public class Solution_D4_1232_사칙연산 {

	public static Node[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			int n = Integer.parseInt(br.readLine());
			arr = new Node[n];

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int num = Integer.parseInt(st.nextToken()) - 1;
				int left = 0, right = 0, val = 0;
				char op = '.';
				// 숫자
				if (st.countTokens() == 1)
					val = Integer.parseInt(st.nextToken());
				// 연산자
				else {
					op = st.nextToken().charAt(0);
					left = Integer.parseInt(st.nextToken()) - 1;
					right = Integer.parseInt(st.nextToken()) - 1;
				}
				Node node = new Node(op, val, left, right);
				arr[num] = node;

			}
			int res = postOrder(0);
			System.out.println("#" + tc + " " + res);
		}
	}

	public static class Node {
		char op;
		int val, left, right;

		public Node(char op, int val, int left, int right) {
			this.op = op;
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static int postOrder(int num) {

		char op = arr[num].op;
		if (op == '.')
			return arr[num].val;

		int left = postOrder(arr[num].left);
		int right = postOrder(arr[num].right);

		int res = (int) (op == '+' ? left + right
				: op == '-' ? left - right : op == '*' ? left * right : left / (right * 1.0));

		return res;
	}
}