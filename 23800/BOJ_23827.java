import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final long MOD = 1000000007;
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) arr[i] = Long.parseLong(st.nextToken());
        long[] prefixSum = new long[n+2];
        for (int i = n; i >= 1; i--) {
            prefixSum[i] += prefixSum[i+1] + arr[i];
        }
        long sum = 0l;
        for (int i = 1; i <= n; i++) {
            sum += arr[i] * prefixSum[i+1];
            sum %= MOD;
        }
        System.out.println(sum);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
