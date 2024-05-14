import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1 << 16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n+1][n+1];
        for (int[] row : arr) Arrays.fill(row, -1100000000);
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] = dp[i][j-1] + need(arr, new int[]{i, j-1}, new int[]{i, j});
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + need(arr, new int[]{i-1, j}, new int[]{i, j}));
            }
        }

        System.out.println(dp[n][n]);
    }

    private int need(int[][] arr, int[] from, int[] to) {
        int f = arr[from[0]][from[1]];
        int t = arr[to[0]][to[1]];

        if (f > t) return 0;
        return t-f+1;
    }
}
