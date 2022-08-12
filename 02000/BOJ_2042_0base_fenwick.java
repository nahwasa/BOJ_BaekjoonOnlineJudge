import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private long[] bit, arr;
    private int n;

    private long query(int b, int c) {
        return getPrefixSum(c) - getPrefixSum(b-1);
    }

    private long getPrefixSum(int idx) {
        long answer = 0l;
        while (idx >= 0) {
            answer += bit[idx];
            idx = (idx&(idx+1))-1;
        }
        return answer;
    }

    private void update(int idx, long val) {
        long diff = val - arr[idx];
        arr[idx] = val;

        while (idx < n) {
            bit[idx] += diff;
            idx |= idx+1;
        }
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int mk = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
        arr = new long[n];
        bit = new long[n];
        for (int i = 0; i < n; i++) {
            update(i, Long.parseLong(br.readLine()));
        }
        StringBuilder sb = new StringBuilder();
        while (mk-->0) {
            st = new StringTokenizer(br.readLine());
            switch (Integer.parseInt(st.nextToken())) {
                case 1: update(Integer.parseInt(st.nextToken())-1, Long.parseLong(st.nextToken())); break;
                case 2: sb.append(query(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1)).append('\n'); break;
            }
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
