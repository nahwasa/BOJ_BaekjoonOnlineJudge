import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1 << 16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        Bit[] bit = new Bit[2];
        bit[0] = new Bit(n);
        bit[1] = new Bit(n);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) updateBothBit(bit, i, Integer.parseInt(st.nextToken()));

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (m-->0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 1) updateBothBit(bit, b, c);
            else sb.append(bit[a-2].query(b, c)).append('\n');
        }

        System.out.print(sb);
    }

    private void updateBothBit(Bit[] bit, int ith, int value) {
        bit[0].update(ith, value%2==0?1:0);
        bit[1].update(ith, value%2==0?0:1);
    }
}

class Bit {
    private int[] bit, arr;
    private int n;

    Bit(int n) {
        this.n = n;
        bit = new int[n+1];
        arr = new int[n+1];
    }

    void update(int ith, int val) {
        int diff = val - arr[ith];
        if (diff == 0) return;

        arr[ith] = val;

        while (ith <= n) {
            bit[ith] += diff;
            ith += ith&-ith;
        }
    }

    int query(int b, int c) {
        return getPrefixSum(c) - getPrefixSum(b-1);
    }

    private int getPrefixSum(int ith) {
        int answer = 0;
        while (ith > 0) {
            answer += bit[ith];
            ith -= ith&-ith;
        }
        return answer;
    }
}
