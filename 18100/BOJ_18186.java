import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static long[] cost = new long[4];
    private long tripleMin(long a, long b, long c) {
        return Math.min(Math.min(a,b),c);
    }
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        cost[1] = b;
        cost[2] = b+c;
        cost[3] = b+2*c;
        long[] arr = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        long sum = 0l;

        if (b <= c) {
            for (int i = 0; i < n; i++) {
                sum += (long)arr[i]*b;
            }
            System.out.println(sum);
            return;
        }

        for (int i = 0; i < n-2; i++) {
            if (arr[i+1]>arr[i+2]) {
                long num = Math.min(arr[i], arr[i+1] - arr[i+2]);
                arr[i] -= num;
                arr[i + 1] -= num;
                sum += 1l * num * cost[2];
            }
            long min = tripleMin(arr[i], arr[i+1], arr[i+2]);
            arr[i]-=min;
            arr[i+1]-=min;
            arr[i+2]-=min;
            sum += min * cost[3];

        }
        for (int i = 0; i < n-1; i++) {
            long min = Math.min(arr[i], arr[i+1]);
            arr[i]-=min;
            arr[i+1]-=min;
            sum += min* cost[2];
        }
        for (int i = 0; i < n; i++) {
            sum += arr[i]* cost[1];
        }
        System.out.println(sum);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
