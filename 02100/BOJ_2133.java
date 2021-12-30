import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.function.Function;

public class Main {
    Function<Integer, Boolean> isOdd = (n) -> (n&1)==1;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        if (isOdd.apply(n)) {
            System.out.println(0);
            return;
        }
        int[] dp = new int[Math.max(n/2, 2)];
        dp[0] = 3;
        dp[1] = 11;
        int tmp = 0;
        for (int i = 2; i < n/2; i++) {
            dp[i] = dp[i-1] * 3 + 2 + (tmp+=dp[i-2]*2);
        }
        System.out.println(dp[n/2-1]);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
