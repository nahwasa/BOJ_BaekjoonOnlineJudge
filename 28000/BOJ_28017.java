import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] dp = new int[m];
        while (n-->0) {
            st = new StringTokenizer(br.readLine());
            int[] curDp = new int[m];
            for (int i = 0; i < m; i++) {
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < m; j++) {
                    if (i == j) continue;

                    min = min(min, dp[j]);
                }

                curDp[i] = Integer.parseInt(st.nextToken()) + min;
            }
            dp = curDp;
        }

        System.out.println(Arrays.stream(dp).min().getAsInt());
    }
}
