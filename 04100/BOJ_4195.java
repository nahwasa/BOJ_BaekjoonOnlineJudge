import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	private static int[] arr;

	private static int find(int a) {
		if (arr[a] < 0)	return a;
		return arr[a] = find(arr[a]);
	}
	
	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a == b)	return;
		int hi = arr[a]<arr[b] ? a:b;
		int lo = arr[a]<arr[b] ? b:a;
		arr[hi] += arr[lo];
		arr[lo] = hi;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		arr = new int[200000];
		int[] cnt = new int[200000];
		while (tc-->0) {
			Arrays.fill(arr, -1);
			Arrays.fill(cnt, 1);
			int n = Integer.parseInt(br.readLine());
			Map<String, Integer> map = new HashMap<>();
			int mapIdx = -1;
			while (n-->0) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String f1 = st.nextToken();
				String f2 = st.nextToken();
				if (!map.containsKey(f1))	map.put(f1, ++mapIdx);
				if (!map.containsKey(f2))	map.put(f2, ++mapIdx);
				int f1n = map.get(f1);
				int f2n = map.get(f2);
				
				if (find(f1n) == find(f2n)) {
					sb.append(cnt[find(f1n)]);
					sb.append("\n");
					continue;
				}
				int fSum = cnt[find(f1n)] + cnt[find(f2n)];
				union(f1n, f2n);
				cnt[find(f1n)] = fSum;
				sb.append(fSum);
				sb.append("\n");
			}
		}
		System.out.println(sb);
		br.close();
	}
}
