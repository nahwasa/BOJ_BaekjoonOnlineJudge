import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n+1][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        arr[n][0] = arr[0][0];
        arr[n][1] = arr[0][1];

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += 1l*arr[i][0]*arr[i+1][1] - 1l*arr[i+1][0]*arr[i][1];
        }
        sum = Math.abs(sum);
        System.out.printf("%.1f", 1d*sum/2);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
