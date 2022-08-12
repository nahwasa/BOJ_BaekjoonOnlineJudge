import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    int n;
    int[] bit;
    boolean[] chk;

    private int getPrefixSum(int idx) {
        int answer = 0;
        while (idx > 0) {
            answer += bit[idx];
            idx -= idx&-idx;
        }
        return answer;
    }

    private int query(int idx) {
        return getPrefixSum(n) - getPrefixSum(idx);
    }

    private void update(int idx) {
        chk[idx] = true;
        while (idx <= n) {
            bit[idx] += 1;
            idx += idx&-idx;
        }
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> hm = new HashMap<>();
        bit = new int[n+1];
        for (int i = 1; i <= n; i++) {
            hm.put(Integer.parseInt(st.nextToken()), i);
        }

        chk = new boolean[n+1];

        st = new StringTokenizer(br.readLine());
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            int cur = hm.get(Integer.parseInt(st.nextToken()));
            sum += query(cur);
            update(cur);
        }
        System.out.println(sum);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
