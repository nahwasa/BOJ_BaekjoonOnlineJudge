import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        StringBuilder sb = new StringBuilder();
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            StringTokenizer st = new StringTokenizer(br.readLine());
            int minDiff = Integer.MAX_VALUE;
            int idx = 0;
            for (int i = 1; i <= n; i++) {
                int cur = Integer.parseInt(st.nextToken());
                int diff = Math.abs(cur-2023);
                if (minDiff > diff) {
                    minDiff = diff;
                    idx = i;
                }
            }
            sb.append(idx).append('\n');
        }
        System.out.print(sb);
    }
}
