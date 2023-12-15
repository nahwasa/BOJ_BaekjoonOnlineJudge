import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
    private static final int MOD = 123456789;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private List<Integer> getPn(int limit) {
        List<Integer> pn = new ArrayList<>();
        boolean[] isPn = new boolean[limit+1];
        int sqrtN = (int)Math.sqrt(limit);
        for (int i = 3; i <= sqrtN; i+=2) {
            if (isPn[i]) continue;
            int base = i+i;
            while (base <= limit) {
                isPn[base] = true;
                base+=i;
            }
        }
        pn.add(2);
        for (int i = 3; i <= limit; i+=2) {
            if (!isPn[i]) pn.add(i);
        }
        return pn;
    }

    public void solution() throws Exception {
        List<Integer> pn = getPn(40000);
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int cur : pn) {
            for (int i = cur; i <= n; i++) {
                dp[i] += dp[i-cur];
                dp[i] %= MOD;
            }
        }
        System.out.println(dp[n]);
    }
}
