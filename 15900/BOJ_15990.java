import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long[][] dp = new long[1000001][3];	// [n][k] : n항목에 대해 숫자'k+1'이 뒤에 오는 경우의 갯수 
		dp[1][0]=1;	//1
		dp[2][1]=1;	//2
		dp[3][0]=dp[3][1]=dp[3][2]=1;	//2+1, 1+2, 3		
		for(int i = 4; i < dp.length; i++) {
			dp[i][2] = (dp[i-3][0] + dp[i-3][1]) % 1000000009;
			dp[i][1] = (dp[i-2][0] + dp[i-2][2]) % 1000000009;
			dp[i][0] = (dp[i-1][1] + dp[i-1][2]) % 1000000009;
		}		
		int TC = Integer.parseInt(br.readLine());
		while (TC-->0) {
			int N = Integer.parseInt(br.readLine());
			bw.write((dp[N][0]+dp[N][1]+dp[N][2]) % 1000000009 + "\n");
		}		
		bw.flush();
		br.close();
		bw.close();		
	}
}
