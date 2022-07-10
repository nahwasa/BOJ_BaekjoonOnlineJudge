import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static final int MOD = 1_000_000_009;
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine())-1;
        int[] dp = {0,1,1};
        while (n-->0) {
            int[] tmp = new int[3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int idx = (i+j)%3;
                    tmp[idx]+=dp[j];
                    tmp[idx]%=MOD;
                }
            }
            dp = tmp;
        }
        System.out.println(dp[0]);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
