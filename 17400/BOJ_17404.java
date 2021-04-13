import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    private static final int MAX = 1000 * 1000 + 1; // over maximum input
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()) - 1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] dp = new int[3][3]; // 1d: start color, 2d: dp
        // set first house value
        for (int i = 0; i < 3; i++) {
            Arrays.fill(dp[i], MAX);
            dp[i][i] = Integer.parseInt(st.nextToken());
        }
        // solve
        while (n-->0) {
            int[] cost = new int[3];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 3; i++) cost[i] = Integer.parseInt(st.nextToken());
            for (int startColor = 0; startColor < 3; startColor++) {
                int[] dpTmp = dp[startColor];
                int c0 = cost[0] + Math.min(dpTmp[1], dpTmp[2]);
                int c1 = cost[1] + Math.min(dpTmp[0], dpTmp[2]);
                int c2 = cost[2] + Math.min(dpTmp[0], dpTmp[1]);
                dpTmp[0]=c0; dpTmp[1]=c1; dpTmp[2]=c2;
                if (n == 0) dpTmp[startColor] = MAX;
            }
        }
        // result
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) for (int j = 0; j < 3; j++) res=Math.min(res, dp[i][j]);
        System.out.println(res);
    }
}
