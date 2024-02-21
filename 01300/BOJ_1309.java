import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
    private static final int MOD = 9901;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n+1][3];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-1][1] + dp[i-1][2];
            dp[i][1] = dp[i-1][0] + dp[i-1][2];
            dp[i][2] = dp[i-1][0] + dp[i-1][1];
            for (int j = 0; j < 3; j++) dp[i][j]%=MOD;
        }
        System.out.println((dp[n][0]+dp[n][1]+dp[n][2])%MOD);
    }
}
