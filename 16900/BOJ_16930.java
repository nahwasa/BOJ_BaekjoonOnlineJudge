import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos {
    int r, c, dist;

    public Pos(int r, int c, int dist) {
        this.r = r;
        this.c = c;
        this.dist = dist;
    }

    public Pos(int r, int c) {
        this(r, c, 0);
    }

    @Override
    public boolean equals(Object obj) {
        Pos other = (Pos) obj;
        return this.r == other.r && this.c == other.c;
    }
}

public class Main {
    private static final int[] DR = {1, -1, 0, 0};
    private static final int[] DC = {0, 0, -1, 1};
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[][] map = new boolean[r+2][c+2];
        for (int i = 1; i <= r; i++) {
            String row = br.readLine();
            for (int j = 1; j <= c; j++) {
                if (row.charAt(j-1) == '.')
                    map[i][j] = true;
            }
        }

        st = new StringTokenizer(br.readLine());
        Pos start = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        Pos goal = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        Queue<Pos> q = new ArrayDeque<>();
        int[][] v = new int[r+2][c+2];
        for (int[] row : v) Arrays.fill(row, Integer.MAX_VALUE);
        int[][] except = new int[r+2][c+2];
        q.add(start);
        v[start.r][start.c] = 0;

        while (!q.isEmpty()) {
            Pos cur = q.poll();
            if (goal.equals(cur)) {
                System.out.println(cur.dist);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + DR[d];
                int nc = cur.c + DC[d];
                int nDist = cur.dist + 1;
                int cnt = 0;

                while (map[nr][nc] && ++cnt<=k) {
                    if (v[nr][nc] == Integer.MAX_VALUE) {
                        v[nr][nc] = nDist;
                        q.add(new Pos(nr, nc, nDist));
                    }
                    if (v[nr][nc] <= v[cur.r][cur.c]) {
                        break;
                    }
                    nr += DR[d];
                    nc += DC[d];
                }
            }
        }
        System.out.println(-1);
    }
}
