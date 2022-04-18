import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] sum = new int[n+1];
        long[] powSum = new long[n+1];
        for (int i = 1; i <= n; i++) {
            int cur = Integer.parseInt(br.readLine());
            sum[i] = sum[i-1]+cur;
            powSum[i] = powSum[i-1]+cur*cur;
        }
        long max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, powSum[i] * (sum[n]-sum[i]));
        }
        System.out.println(max);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
