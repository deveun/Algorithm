//stack, map
package d456;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution_D4_1218_괄호짝짓기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<Character, Character> map = new HashMap<Character, Character>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
		map.put('<', '>');
		for (int tc = 1; tc <= 10; tc++) {
			int num = Integer.parseInt(br.readLine());
			String str = br.readLine();
			Stack<Character> stack = new Stack<Character>();

			int res = 1;
			for (int i = 0; i < num; i++) {
				if (map.containsKey(str.charAt(i))) {
					stack.add(str.charAt(i));
				} else {
					if (stack.size() == 0 || map.get(stack.peek()) != str.charAt(i)) {
						res = 0;
						break;
					} else
						stack.pop();
				}
			}

			if (stack.size() != 0)
				res = 0;

			System.out.println("#" + tc + " " + res);
		}
	}
}