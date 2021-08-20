import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static final int MOD = 1000000000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n+1][20];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int base = 1;
            for (int j = 0; j < 20; j++) {
                if (i-base < 0) break;
                for (int k = 0; k <= j; k++) {
                    dp[i][j] += dp[i-base][k];
                    dp[i][j] %= MOD;
                }
                base *= 2;
            }
        }
        int sum = 0;
        for (int i = 0; i < 20; i++) {
            sum += dp[n][i];
            sum %= MOD;
        }
        System.out.println(sum);
    }
}
