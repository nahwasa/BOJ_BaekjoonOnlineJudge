import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);
    private static final int MOD = 1_000_000_007;
    private int r, c;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        String base = br.readLine();
        int len = base.length();
        if (checkInvalidity(l, base, len)) {
            System.out.println(0);
            return;
        }

        long[][][] dp = new long[len][r+1][c+1];
        char[][] map = new char[r+1][c+1];
        init(r, c, base, dp, map);

        for (int k = 1; k < len; k++) {

            // for each alphabet of base
            for (int i = 1; i <= r; i++) {
                for (int j = 1; j <= c; j++) {
                    if (map[i][j] != base.charAt(k)) continue;
                    dp[k][i][j] = cases(dp[k-1], i, j);
                }
            }

            // prefix sum
            for (int i = 1; i <= r; i++) {
                for (int j = 1; j <= c; j++) {
                    dp[k][i][j] += dp[k][i-1][j] + dp[k][i][j-1] - dp[k][i-1][j-1];
                    dp[k][i][j] = positiveModResult(dp[k][i][j]);
                }
            }
        }
        System.out.println(dp[len-1][r][c]);
    }

    private boolean checkInvalidity(int l, String base, int len) {
        for (int i = 0; i < len; i++) {
            if (base.charAt(i)-'A'+1 > l) {
                return true;
            }
        }
        return false;
    }

    private void init(int r, int c, String base, long[][][] dp, char[][] map) throws Exception {
        for (int i = 0; i < r; i++) {
            String row = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i+1][j+1] = row.charAt(j);
                dp[0][i+1][j+1] = (map[i+1][j+1]== base.charAt(0) ? 1:0) + dp[0][i][j+1] + dp[0][i+1][j] - dp[0][i][j];
            }
        }
    }

    private long cases(long[][] bf, int i, int j) {
        long answer = bf[r][c];
        answer -= get2dRangeSum(bf, i-1, 1, i+1, c);
        answer -= get2dRangeSum(bf, 1, j-1, r, j+1);
        answer += get2dRangeSum(bf, i-1, j-1, i+1, j+1);

        answer -= get2dRangeSum(bf, i-2, j-2, i-2, j-2);
        answer -= get2dRangeSum(bf, i+2, j-2, i+2, j-2);
        answer -= get2dRangeSum(bf, i-2, j+2, i-2, j+2);
        answer -= get2dRangeSum(bf, i+2, j+2, i+2, j+2);

        return positiveModResult(answer);
    }

    private long get2dRangeSum(long[][] arr, int r1, int c1, int r2, int c2) {
        if (r1==r2 && c1==c2 && (r1<=0||r1>r||c1<=0||c1>c)) return 0;

        if (r1==0) r1=1; if (r1==r+1) r1=r;
        if (r2==0) r2=1; if (r2==r+1) r2=r;
        if (c1==0) c1=1; if (c1==c+1) c1=c;
        if (c2==0) c2=1; if (c2==c+1) c2=c;

        long answer = arr[r2][c2]-arr[r1-1][c2]-arr[r2][c1-1]+arr[r1-1][c1-1];

        return positiveModResult(answer);
    }

    private long positiveModResult(long in) {
        while (in < 0) in += MOD;
        return in%MOD;
    }
}
