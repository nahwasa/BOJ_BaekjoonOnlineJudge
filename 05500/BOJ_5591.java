import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = arr[i-1]+Integer.parseInt(br.readLine());
        }

        int max = 0;
        for (int i = k; i <= n; i++) {
            max = Math.max(max, arr[i]-arr[i-k]);
        }
        System.out.println(max);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
