import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);
    private static final int[] DR = {-1, 0, 0, 1};
    private static final int[] DC = {0, -1, 1, 0};

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[][] dist = new int[r][c];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        Queue<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < r; i++) {
            String row = br.readLine();
            for (int j = 0; j < c; j++) {
                if (row.charAt(j) == '1') {
                    dist[i][j] = 0;
                    q.add(new int[]{i, j});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cr = cur[0];
            int cc = cur[1];
            int curDist = dist[cr][cc];

            for (int d = 0; d < 4; d++) {
                int nr = cr+DR[d];
                int nc = cc+DC[d];

                if (nr<0 || nr>=r || nc<0 || nc>=c || dist[nr][nc] <= curDist+1) continue;
                dist[nr][nc] = curDist + 1;
                q.add(new int[]{nr, nc});
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sb.append(dist[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
