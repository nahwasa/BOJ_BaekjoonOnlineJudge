import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        LinkedList<Integer> sn = new LinkedList<>();
        for (int i = 1; i <= Math.sqrt(n); i++)     sn.add(i*i);
        for (int i = 0; i < n; i++) {
            for (Integer num : sn) {
                if (i+num > n)  break;
                dp[i+num] = Math.min(dp[i+num], dp[i]+1);
            }
        }
        System.out.println(dp[n]);
    }
}
