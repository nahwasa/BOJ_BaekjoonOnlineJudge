import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static int M;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		int i = 0;
		while (st.hasMoreTokens())
			arr[i++] = Integer.parseInt(st.nextToken());
		Arrays.parallelSort(arr);
		solve(0, new LinkedList<Integer>());
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();		
	}
	
	private static void solve(int cnt, List<Integer> sel) {
		if (cnt == M) {
			for (int tmp : sel) {
				sb.append(tmp);
				sb.append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			sel.add(arr[i]);
			solve(cnt+1, sel);
			sel.remove(sel.size()-1);
		}
	}
}
