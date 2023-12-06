import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
    private static final int MOD = 1000000007;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Idx> idxes = new HashMap<>();
        List<Integer> candidates = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            int cur = Integer.parseInt(st.nextToken());
            if (!idxes.containsKey(cur)) {
                candidates.add(cur);
                Idx tmp = new Idx();
                idxes.put(cur, tmp);
            }
            idxes.get(cur).setValue(i);
            arr[i] = arr[i - 1] + cur;
        }

        long max = 0;
        int cnt = 0;
        for (int cur : candidates) {
            long sum = arr[idxes.get(cur).max] - arr[idxes.get(cur).min-1];
            if (sum < max) continue;
            if (sum == max) {
                cnt++;
                continue;
            }

            max = sum;
            cnt = 1;
        }

        System.out.println(max + " " + cnt);
    }
}

class Idx {
    int min, max;

    public Idx() {
        this.min = Integer.MAX_VALUE;
        this.max = Integer.MIN_VALUE;
    }

    public void setValue(int num) {
        min = Math.min(min, num);
        max = Math.max(max, num);
    }
}
