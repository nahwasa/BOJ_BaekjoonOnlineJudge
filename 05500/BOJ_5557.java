import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        long[][] dp = new long[n-1][21];
        dp[0][arr[0]] = 1;
        for (int i = 1; i < n-1; i++) {
            for (int num = 0; num <= 20; num++) {
                if (num-arr[i] >= 0)    dp[i][num]+=dp[i-1][num-arr[i]];
                if (num+arr[i] <= 20)   dp[i][num]+=dp[i-1][num+arr[i]];
            }
        }
        System.out.println(dp[n-2][arr[n-1]]);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
