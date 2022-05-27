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
        for (int i = 1; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());
        int sum = 0;
        for (int i = 1; i <= k; i++) sum+=arr[i];
        int max = sum;
        for (int i = k+1, j=1; i <= n; i++, j++) {
            sum+=arr[i]-arr[j];
            if (max < sum) max = sum;
        }
        System.out.println(max);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
