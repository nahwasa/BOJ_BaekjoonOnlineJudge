import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);
    static final int INF = Integer.MAX_VALUE/3-1;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-->0) sb.append(solve()).append('\n');
        System.out.print(sb);
    }

    private int solve() throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] prefixSum = new int[n];
        int[][] dp = new int[n][n];
        for (int[] row : dp) Arrays.fill(row, INF);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i][i] = 0;
        }
        prefixSum[0] = arr[0];
        for (int i = 1; i < n; i++) prefixSum[i] = arr[i] + prefixSum[i - 1];

        for (int gap = 1; gap < n; gap++) {
            for (int s = 0; s < n - gap; s++) {
                for (int i = s; i < s+gap; i++) {
                    dp[s][s+gap] = Math.min(dp[s][s+gap], dp[s][i] + dp[i+1][s+gap] + prefixSum[s+gap] - (s==0?0:prefixSum[s-1]));
                }
            }
        }
        return dp[0][n - 1];
    }
}
