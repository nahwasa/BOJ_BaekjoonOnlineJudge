import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Math.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n+1][2];
        int[][] arr = new int[n+1][2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr[1][0] = dp[1][0] = Integer.parseInt(st.nextToken());
        arr[1][1] = dp[1][1] = Integer.parseInt(st.nextToken());
        for (int i = 2; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());

            dp[i][0] = arr[i][0]
                    + max(dp[i-1][0] + abs(arr[i-1][1] - arr[i][1]), dp[i-1][1] + abs(arr[i-1][0] - arr[i][1]));
            dp[i][1] = arr[i][1]
                    + max(dp[i-1][0] + abs(arr[i-1][1] - arr[i][0]), dp[i-1][1] + abs(arr[i-1][0] - arr[i][0]));

        }

        System.out.println(max(dp[n][0], dp[n][1]));
    }
}
