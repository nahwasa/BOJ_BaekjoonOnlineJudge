import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Edge {
    int exitNum, weight;

    public Edge(int exitNum, int weight) {
        this.exitNum = exitNum;
        this.weight = weight;
    }
}

class Pos {
    int r, c, dist;

    public Pos(int r, int c, int dist) {
        this.r = r;
        this.c = c;
        this.dist = dist;
    }
}

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int[] DR = {-1, 1, 0, 0};
    private static final int[] DC = {0, 0, -1, 1};
    private static final int BLOCK = -2;
    private static final int PRISONER = -1;
    private static final String IMPOSSIBLE = "impossible";
    private static final int TIME_LIMIT = 200;
    int r, c, exitCount = 0;
    int[][] map;
    List<List<Edge>> edges;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        initInput();
        if (exitCount == 0) {
            System.out.println(IMPOSSIBLE);
            return;
        }
        makeEdges();
        int answer = minimumTime();
        System.out.println(answer==-1 ? IMPOSSIBLE : answer);
    }

    private boolean matching(int prisonerNum, int limit, boolean[] v, int[] matched) {
        for (Edge edge : edges.get(prisonerNum)) {
            int exitNum = edge.exitNum;

            if (v[exitNum] || edge.weight > limit) continue;
            v[exitNum] = true;
            if (matched[exitNum] == -1 || matching(matched[exitNum], limit, v, matched)) {
                matched[exitNum] = prisonerNum;
                return true;
            }
        }
        return false;
    }

    private int minimumTime() {
        for (int t = 1; t <= TIME_LIMIT; t++) {
            int[] matched = new int[exitCount*TIME_LIMIT];
            Arrays.fill(matched, -1);
            boolean valid = true;

            for (int i = 0; i < edges.size() && valid; i++) {
                boolean[] v = new boolean[exitCount*TIME_LIMIT];
                if (!matching(i, t, v, matched)) {
                    valid = false;
                }
            }

            if (valid)
                return t;
        }

        return -1;
    }

    private void makeEdges() {
        edges = new ArrayList<>();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] != PRISONER) continue;
                edges.add(new ArrayList<>());
                makeEdge(new Pos(i, j, 0));
            }
        }
    }

    private void makeEdge(Pos start) {
        List<Edge> edge = edges.get(edges.size()-1);
        boolean[][] v = new boolean[r][c];
        Queue<Pos> q = new ArrayDeque<>();
        q.add(start);
        v[start.r][start.c] = true;

        while (!q.isEmpty()) {
            Pos cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nr = cur.r + DR[d];
                int nc = cur.c + DC[d];
                if (map[nr][nc] == BLOCK || v[nr][nc]) continue;
                v[nr][nc] = true;
                if (map[nr][nc] >= 0) {
                    for (int i = 1; i <= TIME_LIMIT; i++) {
                        edge.add(new Edge(map[nr][nc]*TIME_LIMIT+(i-1), cur.dist + i));
                    }
                    continue;
                }
                q.add(new Pos(nr, nc, cur.dist+1));
            }
        }
    }

    private void initInput() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new int[r][c];
        for (int i = 0; i < r; i++) {
            String row = br.readLine();
            for (int j = 0; j < c; j++) {
                switch (row.charAt(j)) {
                    case 'X': map[i][j] = BLOCK; break;
                    case '.': map[i][j] = PRISONER; break;
                    case 'D': map[i][j] = exitCount++; break;
                }
            }
        }
    }
}
