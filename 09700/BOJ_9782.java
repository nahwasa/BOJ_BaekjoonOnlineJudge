import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        StringBuilder sb = new StringBuilder();
        int t = 1;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) break;

            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            sb.append("Case " + t++ + ": ");
            if (n%2 == 0)
                sb.append(String.format("%.1f", (arr[n/2-1] + arr[n/2]) / 2.0d)).append('\n');
            else
                sb.append(arr[n/2] + ".0").append('\n');
        }
        System.out.print(sb);
    }
}
