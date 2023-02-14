import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int BLOCK = -2;
    private static final int[] DR = {-1, 0, 0, 1};
    private static final int[] DC = {0, 1, -1, 0};

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        Queue<int[]> q = new ArrayDeque<>();
        int[][] d = new int[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                char cur = st.nextToken().charAt(0);
                d[i][j] = cur != '0' ? -1 : BLOCK;
                if (cur == '2') {
                    q.add(new int[]{i, j});
                    d[i][j] = 0;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + DR[i];
                int nc = cur[1] + DC[i];
                if (nr < 0 || nr >= r || nc < 0 || nc >= c) continue;
                if (d[nr][nc] == BLOCK || d[nr][nc] >= 0) continue;
                d[nr][nc] = d[cur[0]][cur[1]] + 1;
                q.add(new int[]{nr, nc});
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (d[i][j] == BLOCK) sb.append(0);
                else sb.append(d[i][j]);
                sb.append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
