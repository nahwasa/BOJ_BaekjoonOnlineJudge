import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= k; tc++) {
            int n = Integer.parseInt(br.readLine());
            int a = 0;  // [n-2]
            int b = 0;  // [n-1]
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (n-->0) {
                int cur = Math.max(b, a + Integer.parseInt(st.nextToken()));
                a = b;
                b = cur;
            }

            sb.append("Data Set ").append(tc).append(':').append('\n').append(Math.max(a, b)).append('\n').append('\n');
        }
        System.out.println(sb);
    }
}
