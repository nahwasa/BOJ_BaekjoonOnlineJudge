import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);
    static final int INF = 20*10000+1;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n+1][1<<21];
        for (int[] row : dp) Arrays.fill(row, INF);
        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {

            for (int j = 0; j < 1<<21; j++) {
                if (dp[i-1][j] == INF) continue;

                for (int k = 1; k <= n; k++) {
                    if ((j&(1<<k)) != 0) continue;
                    dp[i][j|(1<<k)] = Math.min(dp[i][j|(1<<k)], dp[i-1][j] + arr[i][k]);
                }
            }

        }

        int answer = INF;
        for (int j = 0; j < 1<<21; j++) {
            answer = Math.min(answer, dp[n][j]);
        }
        System.out.println(answer);
    }
}
