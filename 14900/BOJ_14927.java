import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder output = new StringBuilder();
    private static final int[] DR = {0, 1, -1, 0, 0};
    private static final int[] DC = {0, 0, 0, 1, -1};
    int n;
    int[][] base;
    int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        init();
        boolean[] swt = new boolean[n];
        dfs(swt, 0);
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    private void dfs(boolean[] swt, int idx) {
        if (idx == n) {
            fill(swt);
            return;
        }

        dfs(swt, idx+1);
        swt[idx] = true;
        dfs(swt, idx+1);
        swt[idx] = false;
    }

    private void fill(boolean[] swt) {
        int cnt = 0;
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = base[i][j];
            }
        }

        for (int j = 0; j < n; j++) {
            if (!swt[j]) continue;
            cnt++;
            for (int d = 0; d < 5; d++) {
                int nr = 0+DR[d];
                int nc = j+DC[d];
                if (nr<0||nr>=n||nc<0||nc>=n) continue;
                arr[nr][nc] = arr[nr][nc]^1;    //swap 1, 0
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i-1][j] == 0) continue;
                cnt++;
                for (int d = 0; d < 5; d++) {
                    int nr = i+DR[d];
                    int nc = j+DC[d];
                    if (nr<0||nr>=n||nc<0||nc>=n) continue;
                    arr[nr][nc] = arr[nr][nc]^1;
                }
            }
        }

        for (int j = 0; j < n; j++) {
            if (arr[n-1][j] == 1)
                return;
        }

        answer = Math.min(answer, cnt);
    }

    private void init() throws Exception {
        n = Integer.parseInt(br.readLine());
        base = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                base[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
