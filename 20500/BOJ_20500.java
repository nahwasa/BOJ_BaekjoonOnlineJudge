import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
    private static final int MOD = 1000000007;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());

        long[][] dp = new long[n+1][15];
        dp[1][1] = dp[1][5] = 1;

        for (int i = 2; i <= n; i++) {

            for (int bf = 0; bf <= 14; bf++) {
                int tmp = bf*10+1;
                tmp%=15;
                dp[i][tmp] += dp[i-1][bf];
                dp[i][tmp] %= MOD;

                tmp = bf*10+5;
                tmp%=15;
                dp[i][tmp] += dp[i-1][bf];
                dp[i][tmp] %= MOD;
            }
        }

        System.out.println(dp[n][0]);
    }
}
