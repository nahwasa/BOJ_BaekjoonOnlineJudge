import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1 << 16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private long[] arr;
    int n;
    long m;

    public void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Long.parseLong(st.nextToken());
        arr = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        long answer = 0l;
        for (int i = 1; i <= n; i++) {
            long tmp = solve(-1, i, 1);
            if (i%2==1) answer+=tmp;
            else answer-=tmp;
        }
        System.out.println(answer);
    }

    private long solve(final int bf, final int cnt, final long mult) {
        if (cnt == 0) {
            return m/mult;
        }

        long result = 0l;
        for (int i = bf+1; i <= n-cnt; i++) {
            result += solve(i, cnt-1, mult*arr[i]);
        }
        return result;
    }
}
