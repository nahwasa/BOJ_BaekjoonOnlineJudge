import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    int n, m;
    int answer = Integer.MAX_VALUE;
    int[][] arr;
    int[][] dist = new int[22][22];
    boolean[] dfsV = new boolean[22];

    private void dfs(int a, int cnt, int distSum) {
        if (cnt == 5) {
            if (answer > distSum) answer = distSum;
            return;
        }
        for (int i = 2; i < 22; i++) {
            if (dist[a][i] == 0 || dfsV[i]) continue;
            dfsV[i] = true;
            dfs(i, cnt+1, distSum+dist[a][i]);
            dfsV[i] = false;
        }
    }
    private void bfs(int r, int c) {
        boolean[][] v = new boolean[n][m];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{r, c, 0});
        v[r][c] = true;
        while (!q.isEmpty()) {
            int cr = q.peek()[0];
            int cc = q.peek()[1];
            int cd = q.peek()[2];
            q.poll();
            for (int dr = -1; dr <= 1; dr++) {
                for (int dc = -1; dc <= 1; dc++) {
                    if (((dr^dc)&1) != 1) continue;
                    int nr = cr+dr;
                    int nc = cc+dc;
                    if (nr<0||nr>=n||nc<0||nc>=m||v[nr][nc]||arr[nr][nc]<0) continue;
                    v[nr][nc] = true;
                    if (arr[nr][nc] > 0) {
                        dist[arr[r][c]][arr[nr][nc]] = cd+1;
                    }
                    q.add(new int[]{nr, nc, cd+1});
                }
            }
        }
    }
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        int num = 2;
        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < m; j++) {
                switch (row.charAt(j)) {
                    case 'S': arr[i][j] = 1; break;
                    case 'K': arr[i][j] = num++; break;
                    case 'X': arr[i][j] = -1; break;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] >= 1)
                    bfs(i, j);
            }
        }
        dfs(1, 0, 0);
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
