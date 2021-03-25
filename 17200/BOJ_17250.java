import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	private static int[] parent;
	
	private static void initUnionFind(int n) {
		parent = new int[n+1];
		for (int i = 0; i <= n; i++)
			parent[i] = -1;
	}
	
	private static int find(int n) {
		if (parent[n] < 0)	return n;
		return parent[n] = find(parent[n]);
	}
	
	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if (a == b)	return;
		int highRank = parent[a] < parent[b] ? a : b;
		int lowRank = parent[a] < parent[b] ? b : a;
		parent[highRank] += parent[lowRank];
		parent[lowRank] = highRank;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// input
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n+1];
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		// proc
		initUnionFind(n);
		while (m-->0) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			int tmp = find(x) == find(y) ? arr[find(x)] : arr[find(x)] + arr[find(y)];
			union(x, y);
			arr[find(x)] = tmp;
			bw.write(tmp + "\n");
		}
		bw.flush();
		br.close();
		bw.close();		
	}
}
