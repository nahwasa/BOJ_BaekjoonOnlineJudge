import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final int[] COST = {0,3,5,7};
    private int tripleMin(int a, int b, int c) {
        return Math.min(Math.min(a,b),c);
    }
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long sum = 0l;
        for (int i = 0; i < n-2; i++) {
            if (arr[i+1]>arr[i+2]) {
                int num = Math.min(arr[i], arr[i + 1] - arr[i + 2]);
                arr[i] -= num;
                arr[i + 1] -= num;
                sum += num * COST[2];
            }
            int min = tripleMin(arr[i], arr[i+1], arr[i+2]);
            arr[i]-=min;
            arr[i+1]-=min;
            arr[i+2]-=min;
            sum += min * COST[3];

        }
        for (int i = 0; i < n-1; i++) {
            int min = Math.min(arr[i], arr[i+1]);
            arr[i]-=min;
            arr[i+1]-=min;
            sum += min*COST[2];
        }
        for (int i = 0; i < n; i++) {
            sum += arr[i]*COST[1];
        }
        System.out.println(sum);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
