// 문자열 찾기 (간단히 idx증가 시키는 것이 나음)
package d123;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_D3_1213_String {

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			String t = br.readLine();
			String find = br.readLine();
			String str = br.readLine();
			int res = 0, sta = 0;
			l: while (sta + find.length() <= str.length()) {
				int pi = 0;
				while (find.charAt(pi) == str.charAt(sta + pi)) {
					pi++;
					 //System.out.println(sta + " " + pi);
					if (pi == find.length()) {
						res++;
						//System.out.println("##" + res);
						sta += pi;
						continue l;
					}
				}
				sta += pi == 0 ? pi + 1 : pi;
				//System.out.println(sta);
			}

			System.out.println("#" + tc + " " + res);
		}
	}
}