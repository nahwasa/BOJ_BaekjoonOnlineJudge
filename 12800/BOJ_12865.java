import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());		
		int[] dp = new int[K+1];
		Arrays.fill(dp, -1);
		dp[0] = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());		
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			for (int k = K; k >= 0; k--) {
				if (dp[k] != -1 && k+w <= K)
					dp[k+w] = Math.max(dp[k+w], dp[k] + v);
			}
		}
		int max = 0;
		for (int value : dp)
			max = Math.max(max, value);
		bw.write(max + "\n");
		bw.flush();
		br.close();
		bw.close();		
	}	
}
