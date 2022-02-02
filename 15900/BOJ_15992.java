import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final int MOD = 1000000009;
    private int[][] dp;

    private int proc(int n, int m) {
        dp = new int[n+1][m+1];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (j > m) break;
                for (int k = 1; k <= 3; k++) {
                    if (i-k < 0) break;
                    dp[i][j] += dp[i-k][j-1];
                    dp[i][j] %= MOD;
                }
            }
        }

        return dp[n][m];
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        proc(1000, 1000);

        while (t-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int answer = dp[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())];
            sb.append(answer).append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
