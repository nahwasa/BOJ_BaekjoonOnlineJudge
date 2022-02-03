import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private long[][] dp = new long[65][11];

    private void initDp() {
        Arrays.fill(dp[1], 1);
        for (int i = 2; i <= 64; i++) {
            for (int j = 1; j <= 10; j++) {
                dp[i][j] += dp[i-1][j] + dp[i][j-1];
            }
        }
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        initDp();
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-->0) {
            int n = Integer.parseInt(br.readLine());
            long sum = 0;
            for (int i = 1; i <= 10; i++) {
                sum += dp[n][i];
            }
            sb.append(sum).append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
