import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    class Pos{
        int r, c, d, dist;
        public Pos(int r, int c, int d, int dist) {
            this.r = r;
            this.c = c;
            this.d = d;
            this.dist = dist;
        }
    }

    private static final int[] DR = {0, 1, -1, 0, 0};
    private static final int[] DC = {0, 0, 0, 1, -1};
    int n;

    private int getDivision(int r, int c) {
        if (r<0 || c<0 || r>=4*n || c>=4*n) return -1;
        return r/4*4+c/4;
    }

    private int[] getRotatedPos(int r, int c) {
        int baseR = r/4*4;
        int baseC = c/4*4;
        r %= 4;
        c %= 4;
        return new int[]{baseR+c, baseC+3-r};
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

        n = Integer.parseInt(br.readLine());
        char[][][] arr = new char[4][n*4][n*4];
        Pos start = null;
        for (int i = 0; i < 4*n; i++) {
            String row = br.readLine();
            for (int j = 0; j < 4*n; j++) {
                char c = row.charAt(j);
                arr[0][i][j] = c;
                if (c=='S') {
                    start = new Pos(i, j, 0, 0);
                }
                int tmpI = i;
                int tmpJ = j;
                for (int x = 1; x <= 3; x++) {
                    int[] nextPos = getRotatedPos(tmpI, tmpJ);
                    tmpI = nextPos[0];
                    tmpJ = nextPos[1];
                    arr[x][tmpI][tmpJ] = c;
                }
            }
        }

        boolean[][][] v = new boolean[4][n*4][n*4];
        Queue<Pos> q = new ArrayDeque<>();
        q.add(start);
        v[0][start.r][start.c] = true;
        while (!q.isEmpty()) {
            Pos cur = q.poll();
            int r = cur.r;
            int c = cur.c;
            int d = cur.d;
            if (arr[d][r][c] == 'E') {
                System.out.println(cur.dist);
                return;
            }
            int cDiv = getDivision(r, c);
            for (int dir = 0; dir < 5; dir++) {
                int nr = r+DR[dir];
                int nc = c+DC[dir];
                int nDiv = getDivision(nr, nc);
                if (nDiv == -1) continue;
                int nd = cDiv == nDiv ? (d+1)%4 : 1;
                int[] nrc = getRotatedPos(nr, nc);
                nr = nrc[0];
                nc = nrc[1];

                if (v[nd][nr][nc] || arr[nd][nr][nc] == '#') continue;
                v[nd][nr][nc] = true;
                q.add(new Pos(nr, nc, nd, cur.dist+1));
            }
        }
        System.out.println(-1);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
