import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final int SEC_OF_DAY = 24*60*60;

    private int timeTokenToSec(StringTokenizer st) {
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        s += h*3600;
        s += m*60;
        return s;
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[SEC_OF_DAY+1];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " :-");
            int a = timeTokenToSec(st) + 1;
            int b = timeTokenToSec(st) + 1;
            arr[a]++;
            if (b+1 <= SEC_OF_DAY)
                arr[b+1]--;
            if (a > b)
                arr[1]++;
        }

        for (int i = 1; i <= SEC_OF_DAY; i++) {
            arr[i] += arr[i-1];
        }
        for (int i = 1; i <= SEC_OF_DAY; i++) {
            arr[i] += arr[i-1];
        }

        int q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (q-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " :-");
            int a = timeTokenToSec(st) + 1;
            int b = timeTokenToSec(st) + 1;
            if (a <= b) {
                long sum = arr[b] - arr[a - 1];
                sb.append(String.format("%.7f", 1d * sum / (b - a + 1))).append('\n');
            } else {
                long sum = arr[SEC_OF_DAY] - arr[a-1] + arr[b];
                sb.append(String.format("%.7f", 1d * sum / (SEC_OF_DAY - a + 1 + b))).append('\n');
            }
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
