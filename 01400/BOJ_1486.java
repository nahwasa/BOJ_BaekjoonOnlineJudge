import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node {
    int r, c, d;
    public Node(int r, int c, int d) {
        this.r = r;
        this.c = c;
        this.d = d;
    }
}

public class Main {
    private static StringTokenizer st;
    private static int r,c,t,d;
    private static int[][] map;
    private static int DIST_LIMIT = 52*52*25*25+1;

    private static int solution(int[][] a, int[][] b) {
        int max = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (a[i][j] + b[i][j] > d)  continue;
                max = Math.max(max, map[i][j]);
            }
        }
        return max;
    }

    private static int getGap(int a, int b) {
        if (Math.abs(a-b) > t) return -1;
        if (a >= b) return 1;
        return (b-a) * (b-a);
    }

    private static int[][] f(boolean reverse) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.d - o2.d;
            }
        });
        int[][] dist = new int[r][c];
        boolean[][] v = new boolean[r][c];

        for (int[] row : dist) Arrays.fill(row, DIST_LIMIT);
        pq.add(new Node(0, 0, 0));
        dist[0][0] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int cr = cur.r;
            int cc = cur.c;
            int cd = cur.d;

            if (v[cr][cc]) continue;
            v[cr][cc] = true;

            for (int dr = -1; dr <= 1; dr++) {
                for (int dc = -1; dc <= 1; dc++) {
                    if (((dr^dc)&1) != 1) continue;
                    int nr = cr + dr;
                    int nc = cc + dc;
                    if (nr < 0 || nr >= r || nc < 0 || nc >= c) continue;
                    int gap = !reverse ? getGap(map[cr][cc], map[nr][nc]) : getGap(map[nr][nc], map[cr][cc]);
                    if (gap == -1 || dist[nr][nc] < cd+gap) continue;

                    dist[nr][nc] = cd+gap;
                    pq.add(new Node(nr, nc, dist[nr][nc]));
                }
            }
        }
        return dist;
    }

    private static int ni() { return Integer.parseInt(st.nextToken()); }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        r=ni(); c=ni(); t=ni(); d=ni();
        map = new int[r][c];
        for (int i = 0; i < r; i++) {
            String row = br.readLine();
            for (int j = 0; j < c; j++) {
                char tmp = row.charAt(j);
                map[i][j] = tmp >= 'a' ? tmp - 'a' + 26 : tmp - 'A';
            }
        }
    }

    public static void main(String[] args) throws Exception {
        init();
        int answer = solution(f(false), f(true));
        System.out.println(answer);
    }
}
