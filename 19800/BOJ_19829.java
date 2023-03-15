import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 1;
        int cnt = 0;
        int bf = -1;
        while (st.hasMoreTokens()) {
            int cur = Integer.parseInt(st.nextToken());
            if (cur==bf) {
                cnt = 1;
                continue;
            }
            if (max < ++cnt) max = cnt;
            bf = cur;
        }
        System.out.println(max);
    }
}
