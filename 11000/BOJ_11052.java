import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) 
			arr[i] = Integer.parseInt(st.nextToken());
		int[] dp = new int[N+1];
		for (int i = 1; i <= N; i++) {
			int max = arr[i];
			for (int j = i-1; j >= 1; j--) {
				int tmp = dp[j] + arr[i-j];
				if (tmp > max) max = tmp;
			}
			dp[i] = max;
		}	
		bw.write(dp[N] + "\n");
		bw.flush();
		br.close();
		bw.close();		
	}
}
