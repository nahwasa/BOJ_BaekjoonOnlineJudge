import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
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
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[][] map = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = st.nextToken().charAt(0) == '1';
            }
        }

        boolean[][][][] v = new boolean[2][n][n][m];
        Queue<Pos> q = new ArrayDeque<>();
        v[0][0][0][0] = true;
        q.add(new Pos(0, 0, 0));
        while (!q.isEmpty()) {
            Pos cur = q.poll();
            int curDayOrNight = (cur.dist/m)%2;

            if (cur.r == n-1 && cur.c == n-1) {
                System.out.printf("%d %s\n", cur.dist/(2*m)+1, curDayOrNight==0 ? "sun" : "moon");
                return;
            }

            for (int d = 0; d < 4; d++) {
                Pos next = new Pos(cur.r+DR[d], cur.c+DC[d], cur.dist+1);
                int cnt = next.dist%m;
                int dayOrNight = (next.dist/m)%2;

                if (next.r<0 || next.r>=n || next.c<0 || next.c>=n) continue;
                if (curDayOrNight == 0 && map[next.r][next.c]) continue;

                if (curDayOrNight == 1 && map[next.r][next.c]) {
                    while (!(next.r < 0 || next.r >= n || next.c < 0 || next.c >= n) && map[next.r][next.c]) {
                        next.r += DR[d];
                        next.c += DC[d];
                    }
                    if (next.r<0 || next.r>=n || next.c<0 || next.c>=n) continue;
                }

                if (v[dayOrNight][next.r][next.c][cnt]) continue;
                v[dayOrNight][next.r][next.c][cnt] = true;
                q.add(next);
            }
        }
        System.out.println(-1);
    }
}

class Pos {
    int r, c, dist;

    public Pos(final int r, final int c, final int dist) {
        this.r = r;
        this.c = c;
        this.dist = dist;
    }
}
