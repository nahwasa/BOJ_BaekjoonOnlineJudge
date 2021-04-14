import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    private static int n, m;
    private static int[] parent;
    private static boolean[][] v;
    private static int[][] arr;

    private static int[] dr = {-1, 0, 0, 1};    //NWES
    private static int[] dc = {0, -1, 1, 0};


    private static int getDir(char c) {
        switch (c) {
            case 'N': return 0;
            case 'W': return 1;
            case 'E': return 2;
            case 'S': return 3;
        }
        return -1;
    }
    private static int getNum(int r, int c) {
        return r * m + c;
    }
    private static int find(int a) {
        if (parent[a] < 0)  return a;
        return parent[a] = find(parent[a]);
    }
    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return;
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
        arr = new int[n][m];
        parent = new int[n*m];
        Arrays.fill(parent, -1);
        v = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = getDir(s.charAt(j));
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!v[i][j])   dfs(i,j);
            }
        }
        int cnt = 0;
        for (int i : parent)    if (i<0) cnt++;
        System.out.println(cnt);
    }

    private static void dfs(int r, int c) {
        if (v[r][c])    return;
        v[r][c] = true;
        int nr = r + dr[arr[r][c]];
        int nc = c + dc[arr[r][c]];
        union(getNum(r,c), getNum(nr,nc));
        if (nr<0||nc<0||nr>=n||nc>=m)   return;
        dfs(nr,nc);
    }
}
