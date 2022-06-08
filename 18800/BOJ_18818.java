import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    class Pos {
        int r, c, dist;
        public Pos(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }
    int[] dr = {1, 0, 0, -1};
    int[] dc = {0, 1, -1, 0};
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][][] v = new boolean[n][n][4];
        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < n; j++) {
                for (int d = 0; d < 4; d++) {
                    v[i][j][d] = row.charAt(j)=='.'?false:true;
                }
            }
        }
        Queue<Pos> q = new ArrayDeque<>();
        q.add(new Pos(0, 0, 0));
        for (int d = 0; d < 4; d++) {
            v[0][0][d] = true;
        }

        while (!q.isEmpty()) {
            Pos cur = q.poll();
            if (cur.r==n-1 && cur.c==n-1) {
                System.out.println(cur.dist);
                return;
            }
            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];
                while (nr>=0&&nr<n&&nc>=0&&nc<n&&!v[nr][nc][d]) {
                    v[nr][nc][d] = true;
                    q.add(new Pos(nr, nc, cur.dist+1));
                    nr+=dr[d];
                    nc+=dc[d];
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
