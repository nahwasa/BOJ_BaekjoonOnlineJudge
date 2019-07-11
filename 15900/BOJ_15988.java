import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		long[] dp = new long[1000001];
		dp[1]=1; dp[2]=2; dp[3]=4;
		for(int i = 4; i < dp.length; i++)
			dp[i] = (dp[i-3] + dp[i-2] + dp[i-1]) % 1000000009;
		int TC = Integer.parseInt(br.readLine());
		while (TC-->0) {
			int N = Integer.parseInt(br.readLine());
			bw.write(dp[N] + "\n");
		}		
		bw.flush();
		br.close();
		bw.close();		
	}
}
