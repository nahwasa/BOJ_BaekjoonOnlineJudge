import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int set = 1;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            int sum = 0;
            for (int i = 0; i < n; i++) {
                int cur = Integer.parseInt(st.nextToken());
                sum += cur;
                arr[i] = cur;
            }
            int cnt = 0;
            sum/=n;
            for (int i = 0; i < n; i++) {
                if (arr[i] > sum) cnt+=arr[i]-sum;
            }
            sb.append(String.format("Set #%d\nThe minimum number of moves is %d.\n\n", set++, cnt));
        }
        System.out.print(sb);
    }
}
