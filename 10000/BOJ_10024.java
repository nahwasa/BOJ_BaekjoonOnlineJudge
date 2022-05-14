import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[1000001];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            arr[x]+=g;
        }
        int sum = 0;
        for (int i = 0; i < 1+2*k && i <= 1000000; i++) {
            sum += arr[i];
        }
        int max = sum;
        for (int i = 1+2*k, j = 0; i <= 1000000; i++, j++) {
            sum -= arr[j];
            sum += arr[i];
            if (sum > max)
                max = sum;
        }
        System.out.println(max);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
