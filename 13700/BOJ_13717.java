import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int max = -1;
        int cntSum = 0;
        String maxName = null;
        while (n-->0) {
            String name = br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cnt = 0;
            int k = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            while (m >= k) {
                int cur = m/k;
                cnt += cur;
                m%=k;
                m += cur*2;
            }
            cntSum += cnt;
            if (max < cnt) {
                max = cnt;
                maxName = name;
            }
        }
        System.out.println(String.format("%d\n%s", cntSum, maxName));
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
