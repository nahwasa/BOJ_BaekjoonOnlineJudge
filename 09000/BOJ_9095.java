import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] dp = new int[12];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= 11; i++)
			dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
		
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			bw.write(dp[Integer.parseInt(br.readLine())] + "\n");
		}
		
		bw.flush();
		br.close();
		bw.close();		
	}	
}
