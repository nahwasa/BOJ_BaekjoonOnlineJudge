import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private long[] bit, arr;
    private int n;

    private long query(int b, int c) {
        return getPrefixSum(c) - getPrefixSum(b-1);
    }

    private long getPrefixSum(int ith) {
        long answer = 0l;
        while (ith > 0) {
            answer += bit[ith];
            ith = ith&(ith-1);
        }
        return answer;
    }

    private void update(int ith, long val) {
        long diff = val - arr[ith];
        arr[ith] = val;

        while (ith <= n) {
            bit[ith] += diff;
            ith += ith&-ith;
        }
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int mk = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
        arr = new long[n+1];
        bit = new long[n+1];
        for (int i = 1; i <= n; i++) {
            update(i, Long.parseLong(br.readLine()));
        }
        StringBuilder sb = new StringBuilder();
        while (mk-->0) {
            st = new StringTokenizer(br.readLine());
            switch (Integer.parseInt(st.nextToken())) {
                case 1: update(Integer.parseInt(st.nextToken()), Long.parseLong(st.nextToken())); break;
                case 2: sb.append(query(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))).append('\n'); break;
            }
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
