import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private long max(long n1, long n2, long n3) {
        return Math.max(n1, Math.max(n2, n3));
    }

    private void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int tmp = Integer.parseInt(st.nextToken());
        int[][] w = new int[tmp+1][tmp+1];
        for (int i = 1; i <= tmp; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= tmp; j++) {
                w[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] arrA = new int[r+1];
        int[] arrB = new int[c+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= r; i++) arrA[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= c; i++) arrB[i] = Integer.parseInt(st.nextToken());

        long[][] dp = new long[r+1][c+1];
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                dp[i][j] = max(dp[i-1][j-1] + w[arrA[i]][arrB[j]], dp[i-1][j], dp[i][j-1]);
            }
        }

        System.out.println(dp[r][c]);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
