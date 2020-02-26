// recursive (in-order / pre-order / post-order)
package d456;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_1231_중위순회 {

	public static Node[] arr;
	public static String res;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			int n = Integer.parseInt(br.readLine());
			arr = new Node[n];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int num = Integer.parseInt(st.nextToken());
				String val = st.nextToken();
				int left = 0, right = 0;
				if (st.countTokens() == 2) {
					left = Integer.parseInt(st.nextToken());
					right = Integer.parseInt(st.nextToken());
				} else if (st.countTokens() == 1)
					left = Integer.parseInt(st.nextToken());

				Node node = new Node(num, val, left, right);
				arr[i] = node;
			}
			res = "#" + tc + " ";
			inorder(1);
			System.out.println(res);
		}
	}

	public static class Node {
		int num, left, right;
		String val;

		public Node(int num, String val, int left, int right) {
			this.num = num;
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static void inorder(int pos) {
		if (arr[pos - 1].right != 0) {
			inorder(arr[pos - 1].left);
			res += arr[pos - 1].val;
			inorder(arr[pos - 1].right);
		} else if (arr[pos - 1].left != 0) {
			inorder(arr[pos - 1].left);
			res += arr[pos - 1].val;
		} else
			res += arr[pos - 1].val;
	}
}