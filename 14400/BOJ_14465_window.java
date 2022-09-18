import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];
        while (b-->0) arr[Integer.parseInt(br.readLine())] = 1;
        int sum = 0;
        for (int i = 1; i <= k; i++)
            sum += arr[i];

        int min = sum;
        for (int i = k+1; i <= n; i++) {
            sum += arr[i] - arr[i-k];
            min = Math.min(min, sum);
        }
        System.out.println(min);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
