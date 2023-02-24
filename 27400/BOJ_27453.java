import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    int r, c, dir, dist;
    public Node(int r, int c) {
        this(r, c, -1, 0);
    }
    public Node(int r, int c, int dir, int dist) {
        this.r = r;
        this.c = c;
        this.dir = dir;
        this.dist = dist;
    }
}

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
        int k = Integer.parseInt(st.nextToken());

        char[][] map = new char[r][c];
        Node start = null;
        for (int i = 0; i < r; i++) {
            String row = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = row.charAt(j);
                if (start == null && map[i][j] == 'S') {
                    start = new Node(i, j);
                }
            }
        }

        boolean[][][] v = new boolean[r][c][4];
        Queue<Node> q = new ArrayDeque<>();
        q.add(start);
        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (map[cur.r][cur.c] == 'H') {
                System.out.println(cur.dist);
                return;
            }
            for (int d = 0; d < 4; d++) {
                if (cur.dir == d) continue;
                int nr = cur.r + DR[d];
                int nc = cur.c + DC[d];
                if (nr<0||nr>=r||nc<0||nc>=c||map[nr][nc]=='X') continue;

                int nd = 3-d;
                int sum = sum(map, cur.r, cur.c, cur.dir, nr, nc);

                if (sum > k || v[nr][nc][nd]) continue;
                v[nr][nc][nd] = true;
                q.add(new Node(nr, nc, nd,cur.dist+1));
            }
        }
        System.out.println(-1);
    }

    private int sum(char[][] map, int r, int c, int dir, int nr, int nc) {
        int answer = bss(map, nr, nc);
        if (dir != -1) answer += bss(map, r+DR[dir], c+DC[dir]);
        return answer + bss(map, r, c);
    }

    private int bss(char[][] map, int r, int c) {
        return map[r][c]=='S'||map[r][c]=='H' ? 0 : map[r][c]-'0';
    }
}
