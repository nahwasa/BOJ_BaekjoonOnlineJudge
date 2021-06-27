import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int r,c,a,b,k,sr,sc,er,ec;
    private static boolean[][] v;
    private static int[][] dist;

    private static void solve() {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        q1.add(sr); q2.add(sc);
        v[sr][sc] = true;
        while (!q1.isEmpty()) {
            int cr = q1.poll();
            int cc = q2.poll();
            if (cr == er && cc == ec) {
                System.out.println(dist[cr][cc]);
                return;
            }

            for (int dr = -1; dr <= 1; dr++) {
                for (int dc = -1; dc <= 1; dc++) {
                    if (((dr^dc)&1) == 0) continue;

                    int nr = cr + dr;
                    int nc = cc + dc;
                    if (nr < 0 || nc < 0 || nr >= r || nc >= c || v[nr][nc]) continue;

                    v[nr][nc] = true;
                    dist[nr][nc] = dist[cr][cc] + 1;
                    q1.add(nr);
                    q2.add(nc);
                }
            }
        }
        System.out.println(-1);
    }
    private static final String FAIL_STRING = "-1";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // input
        r = nextInt(st);
        c = nextInt(st);
        a = nextInt(st);
        b = nextInt(st);
        k = nextInt(st);

        v = new boolean[r][c];
        dist = new int[r][c];

        // set block to visit map
        while (k-->0) {
            st = new StringTokenizer(br.readLine());
            int tmpR = nextInt(st) - 1;
            int tmpC = nextInt(st) - 1;

            for (int i = tmpR-a+1; i <= tmpR; i++) {
                for (int j = tmpC-b+1; j <= tmpC; j++) {
                    if (i < 0 || j < 0) continue;
                    v[i][j] = true;
                }
            }
        }
        for (int i = r-a+1; i < r; i++) Arrays.fill(v[i], true);
        for (int i = 0; i < r-a+1; i++) {
            for (int j = c-b+1; j < c; j++)
                v[i][j] = true;
        }

        // input
        st = new StringTokenizer(br.readLine());
        sr = nextInt(st) - 1;
        sc = nextInt(st) - 1;
        st = new StringTokenizer(br.readLine());
        er = nextInt(st) - 1;
        ec = nextInt(st) - 1;

        if (v[er][ec] || v[sr][sc]) {
            System.out.println(FAIL_STRING);
            return;
        }

        // solution
        solve();
    }

    private static int nextInt(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }
}
