import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] dp = new int[1001];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());

        for (int i = 1; i <= c; i++) {
            for (int j = 0; j < n; j++) {
                int target = i-arr[j];
                if (target < 0 || dp[target] == Integer.MAX_VALUE) continue;
                dp[i] = Math.min(dp[i], dp[target]+1);
            }
        }
        System.out.println(dp[c]);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
