import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    private static final int GOAL = (1<<26)-1;
    int n, ans, tmp;
    int[] exist;

    private void proc(int idx) {
        if (tmp == GOAL) {
            ans += 1<<(n-idx);
            return;
        }
        if (idx == n) return;
        int tmpMem = tmp;

        tmp |= exist[idx];
        proc(idx+1);

        tmp = tmpMem;
        proc(idx+1);
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        exist = new int[n];
        for (int i = 0; i < n; i++) {
            HashSet<Integer> hs = new HashSet<>();
            String cur = br.readLine();
            for (int j = 0; j < cur.length(); j++) {
                int atoi = cur.charAt(j)-'a';
                if (!hs.contains(atoi)) {
                    hs.add(atoi);
                    exist[i] |= 1<<atoi;
                }
            }
        }
        proc(0);
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
