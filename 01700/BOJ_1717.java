import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static final String OP_UNION = "0", OP_CHECK = "1";
	private static final String OUTPUT_YES = "YES\n", OUTPUT_NO = "NO\n";
	private static int[] arr;
	private static int n;
	
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
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new int[n+1];
		Arrays.fill(arr, -1);
		while (m-->0) {
			st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
			case OP_UNION :	union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));	continue;
			case OP_CHECK : bw.write(find(Integer.parseInt(st.nextToken()))==find(Integer.parseInt(st.nextToken())) ? OUTPUT_YES : OUTPUT_NO);
			}
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
