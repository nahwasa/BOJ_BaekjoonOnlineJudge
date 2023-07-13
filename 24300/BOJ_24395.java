import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Math.max;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);
    static final int LIMIT = 50;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] dp = new int[LIMIT+1][LIMIT+1];
        for (int[] row : dp) Arrays.fill(row, -1);
        dp[0][0] = 0;

        while (m-->0) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            for (int i = LIMIT; i >= 0; i--) {
                for (int j = LIMIT; j >= 0; j--) {
                    if (i < r || j < b || dp[i-r][j-b] == -1) continue;

                    dp[i][j] = max(dp[i][j], dp[i-r][j-b] + d);
                }
            }
        }

        List<int[]> target = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            target.add(new int[]{i,max(0,dp[r][b])});
        }

        Collections.sort(target, new Comparator<int[]>() {
            @Override
            public int compare(final int[] o1, final int[] o2) {
                if (o1[1] == o2[1])
                    return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });

        StringBuilder answer = new StringBuilder();
        for (int[] cur : target) {
            answer.append(cur[0]).append(' ').append(cur[1]).append('\n');
        }
        System.out.print(answer);
    }
}
