import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    private static final int INF = 10001;
    
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayList<Integer> coins = new ArrayList<>();
        HashSet<Integer> dupCoinChk = new HashSet<>();
        while(n-->0) {
            int cur = Integer.parseInt(br.readLine());
            if (dupCoinChk.contains(cur) || cur > k) continue;

            dupCoinChk.add(cur);
            coins.add(cur);
        }

        int[] dp = new int[k+1];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < coins.size(); j++) {
                if (i-coins.get(j) < 0) continue;
                if (dp[i] > dp[i-coins.get(j)]+1)
                    dp[i] = dp[i-coins.get(j)]+1;
            }
        }

        System.out.println(dp[k]==INF?-1:dp[k]);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
