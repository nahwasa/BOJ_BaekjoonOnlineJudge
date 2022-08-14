import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    int n;
    long[] bit;

    private void update(int i, long diff) {
        while (i <= n) {
            bit[i] += diff;
            i += i&-i;
        }
    }

    private long query(int i) {
        long sum = 0;
        while (i > 0) {
            sum += bit[i];
            i -= i&-i;
        }
        return sum;
    }

    private void rangeUpdate(int i, int j, long diff) {
        update(i, diff);
        update(j+1, -diff);
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        bit = new long[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            rangeUpdate(i, i, Integer.parseInt(st.nextToken()));
        }
        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (m-->0) {
            st = new StringTokenizer(br.readLine());
            switch (Integer.parseInt(st.nextToken())) {
                case 1: rangeUpdate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())); break;
                case 2: sb.append(query(Integer.parseInt(st.nextToken()))).append('\n'); break;
            }
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
