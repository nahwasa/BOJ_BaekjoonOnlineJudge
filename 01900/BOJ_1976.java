import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int[] arr;
	private static int n;
	private static final String RES_YES = "YES";
	private static final String RES_NO = "NO";
	
	
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
		n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		if (m == 0) {
			System.out.println(RES_YES);
			return;
		}
		arr = new int[n+1];
		Arrays.fill(arr, -1);
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++)		
				if (st.nextToken().equals("1"))	union(i, j);
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int root = find(Integer.parseInt(st.nextToken()));
		while (st.hasMoreTokens())
			if (root != find(Integer.parseInt(st.nextToken()))) {
				System.out.println(RES_NO);
				return;
			}
		System.out.println(RES_YES);
		br.close();
	}
}
