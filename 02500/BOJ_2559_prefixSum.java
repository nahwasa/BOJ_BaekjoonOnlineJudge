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
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) arr[i] = arr[i-1]+Integer.parseInt(st.nextToken());
        int max = -10000001;
        for (int i = k; i <= n; i++) {
            int rangeSum = arr[i]-arr[i-k];
            if (max < rangeSum) max = rangeSum;
        }
        System.out.println(max);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
