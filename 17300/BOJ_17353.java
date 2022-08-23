import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    long[] bit1, bit2;
    int n;

    private void update(int bitType, int idx, long diff) {
        long[] bit = bitType==1 ? bit1 : bit2;
        while (idx <= n) {
            bit[idx] += diff;
            idx += idx&-idx;
        }
    }

    private void rangeUpdate(int a, int b, long diff) {
        update(1, a, diff);
        update(1, b+1, -diff);
        update(2, a, diff * (a-1));
        update(2, b+1, -diff * b);
    }

    private long getBitValue(int bitType, int idx) {
        long[] bit = bitType==1 ? bit1 : bit2;
        long answer = 0;
        while (idx > 0) {
            answer += bit[idx];
            idx -= idx&-idx;
        }
        return answer;
    }

    private long prefixSum(int idx) {
        return getBitValue(1, idx) * idx - getBitValue(2, idx);
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        bit1 = new long[n+1];
        bit2 = new long[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int cur = Integer.parseInt(st.nextToken());
            rangeUpdate(i, i, cur);
            rangeUpdate(i+1, i+1, -cur);
        }

        int q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (q-->0) {
            st = new StringTokenizer(br.readLine());
            switch (Integer.parseInt(st.nextToken())) {
                case 1:
                    int l = Integer.parseInt(st.nextToken());
                    int r = Integer.parseInt(st.nextToken());
                    rangeUpdate(l, r, 1);
                    rangeUpdate(r+1, r+1, -r+l-1);
                    break;
                case 2:
                    int x = Integer.parseInt(st.nextToken());
                    sb.append(prefixSum(x)).append('\n');
                    break;
            }
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
