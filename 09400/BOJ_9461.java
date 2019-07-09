import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		int TC = Integer.parseInt(br.readLine());
		long[] dp = new long[100];
		dp[0]=dp[1]=dp[2]=1;
		for (int i = 3; i < 100; i++) {
			dp[i] = dp[i-3]+dp[i-2];
		}
		
		while (TC-->0) {
			bw.write(dp[Integer.parseInt(br.readLine())-1]+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}	
}
