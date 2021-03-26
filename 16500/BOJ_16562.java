import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int[] arr;
	private static int n;
	private static final String RES_NO = "Oh no";
	
	
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
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		arr = new int[n+1];
		Arrays.fill(arr, -1);
		int[] friendCost = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++)	friendCost[i] = Integer.parseInt(st.nextToken());
		while (m-->0) {
			st = new StringTokenizer(br.readLine());
			union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		int[] minCost = new int[n+1];
		Arrays.fill(minCost, 10001);
		for (int i = 1; i <= n; i++) {
			minCost[find(i)] = Math.min(minCost[find(i)], friendCost[i]);
		}
		int sum = 0;
		for (int i = 1; i <= n; i++)
			if (minCost[i] != 10001)	sum += minCost[i];
		System.out.println(sum <= k ? sum : RES_NO);
		br.close();
	}
}
