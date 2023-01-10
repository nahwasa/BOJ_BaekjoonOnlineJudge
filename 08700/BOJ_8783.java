import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<13);
    private static StringBuilder sb = new StringBuilder();
    private static final int[] DR = {0, 0, -1, 1};
    private static final int[] DC = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        int tc = Integer.parseInt(br.readLine());
        while (tc-->0) {
            new Main().solution();
        }
        System.out.print(sb);
    }

    public void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        boolean[][] arr = new boolean[n+2][n+2];
        for (int i = 1; i <= n; i++) {
            String row = br.readLine();
            for (int j = 1; j <= n; j++) {
                if (row.charAt(j-1) == '#')
                    arr[i][j] = true;
            }
        }

        boolean[][] v = new boolean[n+2][n+2];
        v[0][0] = true;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0,0});
        int cnt = (n+2)*(n+2);
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cr = cur[0];
            int cc = cur[1];
            cnt--;
            for (int d = 0; d < 4; d++) {
                int nr = cr + DR[d];
                int nc = cc + DC[d];
                if (nr<0||nr>=n+2||nc<0||nc>=n+2||v[nr][nc]||arr[nr][nc]) continue;
                v[nr][nc] = true;
                q.add(new int[]{nr, nc});
            }
        }
        sb.append(cnt).append('\n');
    }
}
