import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
    private static final int MOD = 1000000007;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int[] dp = new int[4];
        for (int i = 0; i < n; i++) {
            switch (s.charAt(i)) {
                case 'W': dp[0]++; dp[0]%=MOD; break;
                case 'H': dp[1]+=dp[0]; dp[1]%=MOD; break;
                case 'E':
                    dp[3]*=2; dp[3]%=MOD;
                    dp[3]+=dp[2]; dp[3]%=MOD;
                    dp[2]+=dp[1]; dp[2]%=MOD;
                    break;
            }
        }
        System.out.println(dp[3]);
    }
}
