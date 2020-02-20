//LinkedHashMap
package d123;

import java.io.*;
import java.util.*;

public class Solution_D3_1221_GNS {

	public static String[] num = { "ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN" };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Map<String, Integer> map = new LinkedHashMap<String, Integer>();

		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			for (int i = 0; i < 10; i++)
				map.put(num[i], 0);

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			st.nextToken();
			int len = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < len; i++) {
				String str = st.nextToken();
				map.put(str, map.get(str) + 1);
			}

			bw.append("#" + t + "\n");
			Set<String> keys = map.keySet();
			for (String key : keys) {
				int cnt = map.get(key);
				while (cnt-- > 0)
					bw.append(key + " ");
			}
			bw.append("\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}

}