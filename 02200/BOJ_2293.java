import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n+1];
        for (int i = 1; i <= n; i++)
            coins[i] = Integer.parseInt(br.readLine());
        Arrays.sort(coins);

        int[][] dp = new int[n+1][k+1];
        for (int i = 1; i <= n; i++)
            dp[i][0] = 1;

        for (int value = 1; value <= k; value++) {
            for (int eachCoin = 1; eachCoin <= n; eachCoin++) {
                dp[eachCoin][value] = ( value-coins[eachCoin]<0 ? 0 : dp[eachCoin][value-coins[eachCoin]] ) + dp[eachCoin-1][value];
            }
        }
        System.out.println(dp[n][k]);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
