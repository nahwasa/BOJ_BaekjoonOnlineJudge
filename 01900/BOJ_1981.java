import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static final int NUMBER_LIMIT = 200;
    private static final int[] DR = {-1, 0, 0, 1};
    private static final int[] DC = {0, 1, -1, 0};
    private int n, low, high;
    private int[][] arr;
    HashSet<Integer> numbers;

    private boolean isPossible(int s, int e) {
        if (s > low || e < high)
            return false;

        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] v = new boolean[n][n];
        q.add(new int[]{0, 0});
        v[0][0] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            for (int i = 0; i < 4; i++) {
                int nr = r+DR[i];
                int nc = c+DC[i];
                if (nr<0||nr>=n||nc<0||nc>=n||v[nr][nc]||arr[nr][nc]<s||arr[nr][nc]>e) continue;
                v[nr][nc] = true;
                if (nr == n-1 && nc == n-1)
                    return true;
                q.add(new int[]{nr, nc});
            }
        }
        return false;
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        numbers = new HashSet<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int cur = Integer.parseInt(st.nextToken());
                numbers.add(cur);
                arr[i][j] = cur;
            }
        }
        int start = arr[0][0];
        int goal = arr[n-1][n-1];
        low = start<goal?start:goal;
        high = start<goal?goal:start;

        int s = 0, e = 0;
        int ans = NUMBER_LIMIT;
        while (s <= e && e <= NUMBER_LIMIT) {
            if (isPossible(s, e)) {
                ans = Math.min(ans, e-s);
                while (!numbers.contains(++s) && s<=e);
            } else {
                while (!numbers.contains(++e) && e<=NUMBER_LIMIT);
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
