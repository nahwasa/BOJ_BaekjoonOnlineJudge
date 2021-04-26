import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n+1][2];
        dp[1][0] = Integer.MIN_VALUE;
        dp[1][1] = nextInt();
        for (int i = 2; i <= n; i++) {
            int tmp = nextInt();
            dp[i][0] = dp[i-1][1] + tmp;
            dp[i][1] = Math.max(dp[i-2][0], dp[i-2][1]) + tmp;
        }
        System.out.println(Math.max(dp[n][0], dp[n][1]));
    }

    private static int nextInt() throws Exception {
        return Integer.parseInt(br.readLine());
    }
}
