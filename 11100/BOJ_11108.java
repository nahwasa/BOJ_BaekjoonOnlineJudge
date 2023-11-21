import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);
    private static final int MAX = 10080;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-->0) {
            sb.append(solve()).append('\n');
        }
        System.out.print(sb);
    }

    private int solve() throws Exception {
        int n = Integer.parseInt(br.readLine());
        List<Tv>[] arr = new List[MAX+1];
        for (int i = 0; i < arr.length; i++) arr[i] = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            Tv tv = new Tv(s, d, p);
            arr[tv.e].add(tv);
        }

        int[] dp = new int[MAX+1];
        for (int i = 1; i <= MAX; i++) {
            dp[i] = dp[i-1];
            for (Tv cur : arr[i]) {
                dp[i] = Math.max(dp[i], dp[cur.s] + cur.p);
            }
        }

        return dp[MAX];
    }
}

class Tv {
    int s, e, p;

    public Tv(int s, int d, int p) {
        this.s = s;
        this.e = s + d;
        this.p = p;
    }
}
