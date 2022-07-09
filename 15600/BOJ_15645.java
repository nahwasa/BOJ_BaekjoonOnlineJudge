import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final int VALUE_SUM_LIMIT = 9*100000+1;
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][][] dp = new int[n+1][3][2];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                int cur = Integer.parseInt(st.nextToken());
                dp[i][j][1] = VALUE_SUM_LIMIT;
                for (int k = j-1; k <= j+1; k++) {
                    if (k < 0 || k >= 3) continue;
                    dp[i][j][0] = Math.max(dp[i][j][0], dp[i-1][k][0]);
                    dp[i][j][1] = Math.min(dp[i][j][1], dp[i-1][k][1]);
                }
                dp[i][j][0]+=cur;
                dp[i][j][1]+=cur;
            }
        }
        int max = Math.max(dp[n][0][0], Math.max(dp[n][1][0], dp[n][2][0]));
        int min = Math.min(dp[n][0][1], Math.min(dp[n][1][1], dp[n][2][1]));
        System.out.println(max + " " + min);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
