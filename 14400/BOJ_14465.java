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
        for (int i = 1; i <= k; i++)
            arr[i] += arr[i-1];

        int min = arr[k];
        for (int i = k+1; i <= n; i++) {
            arr[i] += arr[i-1];
            min = Math.min(min, arr[i]-arr[i-k]);
        }
        System.out.println(min);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
