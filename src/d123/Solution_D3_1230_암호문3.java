//ArrayList
package d123;

import java.io.*;
import java.util.*;

public class Solution_D3_1230_암호문3 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 1; tc++) {
			int num = Integer.parseInt(br.readLine());
			ArrayList<String> al = new ArrayList<String>();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			while (num-- > 0)
				al.add(st.nextToken());

			int order = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			int x, y;
			for (int i = 0; i < order; i++) {
				switch (st.nextToken()) {
				case "I":
					x = Integer.parseInt(st.nextToken());
					y = Integer.parseInt(st.nextToken());
					while (y-- > 0)
						al.add(x++, st.nextToken());
					break;
				case "D":
					x = Integer.parseInt(st.nextToken());
					y = Integer.parseInt(st.nextToken());
					while (y-- > 0)
						al.remove(x);
					break;
				case "A":
					y = Integer.parseInt(st.nextToken());
					while (y-- > 0)
						al.add(st.nextToken());
					break;
				}
			}

			StringBuilder sb = new StringBuilder("#" + tc + " ");
			for (int i = 0; i < 10; i++)
				sb.append(al.get(i) + " ");
			System.out.println(sb);
		}

	}
}