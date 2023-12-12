import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] num = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[m][k];
        for (int cur : num) {
            if (cur == 0) continue;
            dp[0][cur%k] += 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < k; j++) {
                int bf = dp[i-1][j];
                if (bf == 0) continue;

                for (int cur : num) {
                    int nextNum = j*10+cur;
                    nextNum %= k;

                    dp[i][nextNum] += bf;
                    dp[i][nextNum] %= MOD;
                }
            }
        }
        System.out.println(dp[m-1][0]);
    }
}
