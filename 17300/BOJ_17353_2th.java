import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    int n;
    long[] cntBit, sumBit;

    private void update(long[] bit, int i, long diff) {
        while (i <= n) {
            bit[i] += diff;
            i += i&-i;
        }
    }

    private long query(long[] bit, int i) {
        long sum = 0;
        while (i > 0) {
            sum += bit[i];
            i -= i&-i;
        }
        return sum;
    }

    private void rangeUpdate(long[] bit, int i, int j, long diff) {
        update(bit, i, diff);
        update(bit, j+1, -diff);
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        long[] arr = new long[n+1];
        cntBit = new long[n+1];
        sumBit = new long[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (q-->0) {
            st = new StringTokenizer(br.readLine());
            switch (Integer.parseInt(st.nextToken())) {
                case 1:
                    int l = Integer.parseInt(st.nextToken());
                    int r = Integer.parseInt(st.nextToken());
                    rangeUpdate(cntBit, l, r, 1);
                    rangeUpdate(sumBit, l, r, -l);
                    break;
                case 2:
                    int x = Integer.parseInt(st.nextToken());
                    sb.append(arr[x] + (x+1)*query(cntBit, x) + query(sumBit, x)).append('\n');
                    break;
            }
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}

