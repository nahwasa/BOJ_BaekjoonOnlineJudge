import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        while (q-->0) {
            st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken()) - 1;
            long y = Long.parseLong(st.nextToken()) - 1;

            sb.append(getDist(n, k, x, y)).append('\n');
        }

        System.out.print(sb);
    }

    private long getDist(final long n, final int k, final long x, final long y) {
        long hi = x>y?x:y;
        long lo = x>y?y:x;

        if (k == 1) return hi-lo;

        Map<Long, Integer> exist = new HashMap<>();
        int dist = 0;
        exist.put(lo, dist);
        while (lo != 0) {
            if (lo%k==0) lo = lo/k-1;
            else lo/=k;

            exist.put(lo, ++dist);
        }

        dist = 0;
        while (hi != 0) {
            ++dist;
            if (hi%k==0) hi = hi/k-1;
            else hi/=k;
            if (exist.containsKey(hi))
                return dist+exist.get(hi);
        }

        return -1;
    }
}
