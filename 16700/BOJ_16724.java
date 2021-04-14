import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static final int[] dc = {0, 0, -1, 1};  // U:0, D:1, L:2, R:3
    private static final int[] dr = {-1, 1, 0, 0};
    private static int[] parent;
    private static Pos[][] map;
    private static boolean[][] v;
    private static int n, m;

    private static int find(int a) {
        if (parent[a] < 0)  return a;
        return parent[a] = find(parent[a]);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a==b)   return;
        int h = parent[a] < parent[b] ? a : b;
        int l = parent[a] < parent[b] ? b : a;
        parent[h] += parent[l];
        parent[l] = h;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new Pos[n][m];
        parent = new int[n*m];
        v = new boolean[n][m];
        Arrays.fill(parent, -1);
        int idx = 0;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) map[i][j] = new Pos(s.charAt(j), idx++);
        }
        //solve
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!v[i][j])   dfs(i, j);
            }
        }
        int cnt = 0;
        for (int i = 0; i < parent.length; i++) if (parent[i] < 0) cnt++;
        System.out.println(cnt);
    }

    private static void dfs(int r, int c) {
        if (v[r][c])    return;
        v[r][c] = true;
        Pos tmp = map[r][c];
        int nr = r + dr[tmp.d];
        int nc = c + dc[tmp.d];
        if (nr<0 || nc<0 || nr>=n || nc>=m) return;
        union(tmp.idx, map[nr][nc].idx);
        dfs(nr, nc);
    }
}
class Pos {
    int d, idx;
    public Pos(char dir, int idx) { this.d=getDir(dir); this.idx=idx; }
    private static int getDir(char c) {
        switch (c) {
            case 'U' : return 0;
            case 'D' : return 1;
            case 'L' : return 2;
            case 'R' : return 3;
        }
        return -1;
    }
}
