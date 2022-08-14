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

    private long query(int a, int b) {
        return prefixSum(b) - prefixSum(a-1);
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        bit1 = new long[n+1];
        bit2 = new long[n+1];
        int mk = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            rangeUpdate(i, i, Long.parseLong(br.readLine()));
        }

        StringBuilder sb = new StringBuilder();
        while (mk-->0) {
            st = new StringTokenizer(br.readLine());
            switch (Integer.parseInt(st.nextToken())) {
                case 1:
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    long diff = Long.parseLong(st.nextToken());
                    rangeUpdate(a, b, diff);
                    break;
                case 2:
                    int i = Integer.parseInt(st.nextToken());
                    int j = Integer.parseInt(st.nextToken());
                    sb.append(query(i, j)).append('\n');
                    break;
            }
        }
        System.out.print(sb);
    }

  public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
