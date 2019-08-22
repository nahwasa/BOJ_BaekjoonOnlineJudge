import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	private static int max = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] t = new int[N+1];
		int[] p = new int[N+1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i <= N; i++) {
			recursion(t, p, i+t[i], N, p[i]);
		}
		bw.write(max + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static void recursion(int[] t, int[] p, int idx, int N, int sum) {
		if (idx > N+1)
			return;
		max = Math.max(max, sum);		
		for (int i = idx; i <= N; i++) {
			recursion(t, p, i+t[i], N, sum+p[i]);
		}
	}
}
