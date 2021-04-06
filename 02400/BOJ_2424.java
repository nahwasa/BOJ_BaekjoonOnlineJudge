import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[][] arr = new boolean[n][m];
        Pos s=null, e=null;
        Queue<Pos> pirateQ = new LinkedList<>();
        boolean[][] v = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                switch (input.charAt(j)) {
                    case 'V' : pirateQ.add(new Pos(i, j, 0)); v[i][j] = true; break;
                    case 'Y' : s = new Pos(i, j, 0); break;
                    case 'T' : e = new Pos(i, j, 0); break;
                    case 'I' : arr[i][j] = true; break;
                }
            }
        }
        // pirate pre-processing
        int[][] pArr = new int[n][m];
        while (!pirateQ.isEmpty()) {
            Pos tmp = pirateQ.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if (nx<0||nx>=m||ny<0||ny>=n||v[ny][nx])   continue;
                if (arr[ny][nx]) {
                    pArr[ny][nx] = Integer.MAX_VALUE;
                    v[ny][nx] = true;
                    continue;
                }
                pArr[ny][nx] = tmp.d + 1;
                v[ny][nx] = true;
                pirateQ.add(new Pos(ny, nx, tmp.d + 1));
            }
        }
        // make pirate dp
        int[][] pdp = new int[n][m];
        for (int i = 0; i < n; i++) Arrays.fill(pdp[i], Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            int min = pArr[i][0];
            pdp[i][0] = Math.min(pdp[i][0], min);
            for (int j = 1; j < m; j++) {
                min = arr[i][j] ? Integer.MAX_VALUE : Math.min(min, pArr[i][j]);
                pdp[i][j] = Math.min(pdp[i][j], min);
            }
        }
        for (int i = 0; i < n; i++) {
            int min = pArr[i][m-1];
            pdp[i][m-1] = Math.min(pdp[i][m-1], min);
            for (int j = m-2; j >= 0; j--) {
                min = arr[i][j] ? Integer.MAX_VALUE : Math.min(min, pArr[i][j]);
                pdp[i][j] = Math.min(pdp[i][j], min);
            }
        }
        for (int j = 0; j < m; j++) {
            int min = pArr[0][j];
            pdp[0][j] = Math.min(pdp[0][j], min);
            for (int i = 1; i < n; i++) {
                min = arr[i][j] ? Integer.MAX_VALUE : Math.min(min, pArr[i][j]);
                pdp[i][j] = Math.min(pdp[i][j], min);
            }
        }
        for (int j = 0; j < m; j++) {
            int min = pArr[n-1][j];
            pdp[n-1][j] = Math.min(pdp[n-1][j], min);
            for (int i = n-2; i >= 0; i--) {
                min = arr[i][j] ? Integer.MAX_VALUE : Math.min(min, pArr[i][j]);
                pdp[i][j] = Math.min(pdp[i][j], min);
            }
        }
        // sua bfs
        Queue<Pos> q = new LinkedList<>();
        v = new boolean[n][m];
        q.add(s);
        v[s.y][s.x] = true;
        while (!q.isEmpty()) {
            Pos tmp = q.poll();
            if (tmp.x==e.x && tmp.y==e.y) {
                System.out.println("YES");
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                int nd = tmp.d + 1;
                if (nx<0||nx>=m||ny<0||ny>=n||arr[ny][nx]||v[ny][nx]||nd>=pdp[ny][nx])   continue;
                v[ny][nx] = true;
                q.add(new Pos(ny, nx, nd));
            }
        }
        System.out.println("NO");
    }
}
class Pos {
    int x, y, d;
    public Pos(int y, int x, int d) { this.x=x; this.y=y; this.d=d; }
}
