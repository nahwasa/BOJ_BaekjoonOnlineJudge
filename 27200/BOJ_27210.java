import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int max = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int cur = arr[i] == 1 ? 1 : -1;
            sum += cur;
            if (sum > max) max = sum;
            if (sum < 0) sum = 0;
        }

        sum = 0;
        for (int i = 0; i < n; i++) {
            int cur = arr[i] == 1 ? -1 : 1;
            sum += cur;
            if (sum > max) max = sum;
            if (sum < 0) sum = 0;
        }

        System.out.println(max);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
