import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        int[][] dp = new int[n][2];

        // chk longest increasing subsequence
        for (int i = 0; i < n; i++) {
            for (int x = 0; x < i; x++)
                if (arr[x] < arr[i]) dp[i][0] = Math.max(dp[i][0], dp[x][0] + 1);
        }

        // chk longest decreasing subsequence
        for (int i = n-1; i >= 0; i--) {
            for (int x = n-1; x > i; x--)
                if (arr[x] < arr[i]) dp[i][1] = Math.max(dp[i][1], dp[x][1] + 1);
        }

        // find longest bitonic subsequence length
        int max = 0;
        while (--n >= 0) max = Math.max(max, dp[n][0] + dp[n][1]);
        System.out.println(max + 1);
    }
}
