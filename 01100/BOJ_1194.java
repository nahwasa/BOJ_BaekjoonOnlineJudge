import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos {
    int r, c, dist, key;
    public Pos(int r, int c, int dist, int key) {
        this.r = r;
        this.c = c;
        this.dist = dist;
        this.key = key;
    }
}

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);
    private static final int[] DR = {-1, 0, 0, 1};
    private static final int[] DC = {0, 1, -1, 0};
    private static final int INF = 2<<6 + 2;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        char[][] map = new char[r][c];
        Pos start = null;
        for (int i = 0; i < r; i++) {
            String row = br.readLine();
            for (int j = 0; j < c; j++) {
                char cur = row.charAt(j);
                if (cur == '0') start = new Pos(i, j, 0, 0);
                map[i][j] = cur;
            }
        }

        boolean[][][] v = new boolean[64][r][c];
        Queue<Pos> q = new ArrayDeque<>();

        int[] qNum = new int[64];
        Arrays.fill(qNum, -1);
        qNum[0] = 0;
        q.add(start);
        v[0][start.r][start.c] = true;

        while (!q.isEmpty()) {
            Pos cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nr = cur.r + DR[d];
                int nc = cur.c + DC[d];
                int dist = cur.dist + 1;
                int key = cur.key;

                if (nr<0 || nr>=r || nc<0 || nc>=c || v[key][nr][nc] || map[nr][nc]=='#') continue;
                if (map[nr][nc] == '1') {
                    System.out.println(dist);
                    return;
                }
                v[key][nr][nc] = true;

                char curMap = map[nr][nc];
                if (curMap >= 'a' && curMap <= 'f') {
                    int keyNum = curMap-'a';
                    if ((key & (1<<keyNum)) == 0) {
                        q.add(new Pos(nr, nc, dist, key));
                        key |= 1<<keyNum;
                        v[key][nr][nc] = true;
                        q.add(new Pos(nr, nc, dist, key));
                        continue;
                    }
                }
                if (curMap >= 'A' && curMap <= 'F' && (key & (1<<(curMap-'A'))) == 0) {
                    continue;
                }
                q.add(new Pos(nr, nc, dist, key));
            }

        }

        System.out.println(-1);
    }
}
