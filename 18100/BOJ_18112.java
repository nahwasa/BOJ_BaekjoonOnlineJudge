import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);
    private static final int LIMIT = 1<<10;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        int s = Integer.parseInt(br.readLine(), 2);
        int e = Integer.parseInt(br.readLine(), 2);

        if (s==e) {
            System.out.println(0);
            return;
        }

        boolean[] v = new boolean[LIMIT];
        Queue<int[]> q = new ArrayDeque<>();
        v[s] = true;
        q.add(new int[] {s, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == e) {
                System.out.println(cur[1]);
                return;
            }
            for (int next : getNextCadidates(cur[0])) {
                if (v[next]) continue;
                v[next] = true;
                q.add(new int[] {next, cur[1]+1});
            }
        }
    }

    private List<Integer> getNextCadidates(int n) {
        List<Integer> candidates = new ArrayList<>();
        if (n+1 < LIMIT) candidates.add(n+1);
        if (n != 0) {
            candidates.add(n-1);

            int bit = 0;
            int msd = Integer.highestOneBit(n);
            while ((1<<bit) != msd) {
                int tmp = n^1<<bit++;
                if (tmp < LIMIT) candidates.add(tmp);
            }
        }
        return candidates;
    }
}
