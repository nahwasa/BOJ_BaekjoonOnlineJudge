import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);
    static StringBuilder sb = new StringBuilder();
    static final int NEGATIVE_INF = -200*10000-1;

    public static void main(String[] args) throws Exception {
        while (true) {
            String str = br.readLine();
            if (str.charAt(0) == '0') break;

            StringTokenizer st = new StringTokenizer(str);
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            int[] coin = new int[n+2];
            int idx = 1;
            while (idx != n+1) {
                st = new StringTokenizer(br.readLine());
                while (st.hasMoreTokens()) coin[idx++] = Integer.parseInt(st.nextToken());
            }

            sb.append(new Main().solution(n, s, t, coin)).append('\n');
        }
        System.out.print(sb);
    }

    private int solution(int n, int s, int t, int[] coin) throws Exception {
        int[] bf = new int[n+2];
        Arrays.fill(bf, NEGATIVE_INF);
        bf[0] = 0;
        int answer = NEGATIVE_INF;

        while (t-->0) {
            int[] dp = new int[n+2];
            Arrays.fill(dp, NEGATIVE_INF);

            for (int i = 1; i <= n+1; i++) {
                for (int gap = 1; gap <= s; gap++) {
                    if (i-gap < 0 || bf[i-gap] == NEGATIVE_INF) continue;

                    dp[i] = Math.max(dp[i], bf[i-gap]+coin[i]);
                }
            }
            answer = Math.max(answer, dp[n+1]);
            bf = dp;
        }

        return answer;
    }
}
