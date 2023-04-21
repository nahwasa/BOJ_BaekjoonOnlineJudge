import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final int LEN = 1000;
    int[] bit1, bit2;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void update(int bitType, int idx, int diff) {
        int[] bit = bitType==1 ? bit1 : bit2;
        while (idx <= LEN) {
            bit[idx] += diff;
            idx += idx&-idx;
        }
    }

    private void rangeUpdate(int a, int b) {
        update(1, a, 1);
        update(1, b+1, -1);
        update(2, a, 1 * (a-1));
        update(2, b+1, -1 * b);
    }

    private int getBitValue(int bitType, int idx) {
        int[] bit = bitType==1 ? bit1 : bit2;
        int answer = 0;
        while (idx > 0) {
            answer += bit[idx];
            idx -= idx&-idx;
        }
        return answer;
    }

    private int prefixSum(int idx) {
        return getBitValue(1, idx) * idx - getBitValue(2, idx);
    }

    private int query(int a, int b) {
        return prefixSum(b) - prefixSum(a-1);
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bit1 = new int[LEN+1];
        bit2 = new int[LEN+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        while (n-->0) {
            int k = Integer.parseInt(br.readLine());
            while (k-->0) {
                st = new StringTokenizer(br.readLine());
                rangeUpdate(Integer.parseInt(st.nextToken())+1, Integer.parseInt(st.nextToken()));
            }
        }

        StringBuilder sb = new StringBuilder();
        int max = 0;
        int a = 0, b = 0;
        for (int i = t; i <= LEN; i++) {
            int cur = query(i-t+1, i);
            if (cur > max) {
                max = cur;
                a = i-t;
                b = i;
            }
        }
        System.out.println(a + " " + b);
    }
}
