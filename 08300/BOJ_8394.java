import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n][2];
        dp[0][0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i][1] = dp[i-1][0];
            dp[i][0] = dp[i-1][0] + dp[i-1][1];
            dp[i][1] %= 10;
            dp[i][0] %= 10;
        }
        System.out.println((dp[n-1][0] + dp[n-1][1])%10);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
