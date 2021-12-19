import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static final int A = 0;
    private static final int B = 1;

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int[][] dp = new int[n][2];
        dp[0][B] = 1-(dp[0][A] = s.charAt(0)=='A'?0:1);
        for (int i = 1; i < n; i++) {
            boolean isA = s.charAt(i) == 'A';
            dp[i][isA?A:B] = Math.min(dp[i-1][isA?A:B], dp[i-1][isA?B:A]+1);
            dp[i][isA?B:A] = Math.min(dp[i-1][isA?A:B], dp[i-1][isA?B:A])+1;
        }
        System.out.println(Math.min(dp[n-1][A], dp[n-1][B]+1));
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
