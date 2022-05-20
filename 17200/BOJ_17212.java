import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static final int[] coin = {1,2,5,7};
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        Arrays.fill(dp, 100001);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 4; j++) {
                if (i-coin[j]<0) continue;
                dp[i] = Math.min(dp[i], dp[i-coin[j]]+1);
            }
        }
        System.out.print(dp[n]);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
