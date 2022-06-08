import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos {
    int r, c, type;
    public Pos(int r, int c, int type) {
        this.r = r;
        this.c = c;
        this.type = type;
    }
}
public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[][] answer = new int[r][c];
        int[][][] map = new int[2][r][c];
        for (int i = 0; i < 2; i++) for (int j = 0; j < r; j++) Arrays.fill(map[i][j], Integer.MAX_VALUE);
        Queue<Pos> q = new ArrayDeque<>();
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                switch (Integer.parseInt(st.nextToken())) {
                    case -1 : answer[i][j] = -1; break;
                    case 1 : q.add(new Pos(i, j, 0)); answer[i][j] = 1; map[0][i][j] = 1; break;
                    case 2 : q.add(new Pos(i, j, 1)); answer[i][j] = 2; map[1][i][j] = 1; break;
                }
            }
        }
        while (!q.isEmpty()) {
            Pos cur = q.poll();
            if (answer[cur.r][cur.c] == 3) continue;
            for (int dr = -1; dr <= 1; dr++) {
                for (int dc = -1; dc <= 1; dc++) {
                    if (((dr ^ dc) & 1) != 1) continue;
                    int nr = cur.r+dr;
                    int nc = cur.c+dc;
                    int type = cur.type;
                    if (nr<0||nr>=r||nc<0||nc>=c||answer[nr][nc]==-1||map[type][nr][nc]!=Integer.MAX_VALUE) continue;
                    int nd = map[type][cur.r][cur.c]+1;
                    if (map[1-type][nr][nc]==nd) {
                        answer[nr][nc] = 3;
                        continue;
                    }
                    if (map[1-type][nr][nc]<nd) continue;
                    answer[nr][nc] = type+1;
                    map[type][nr][nc] = nd;
                    q.add(new Pos(nr, nc, type));
                }
            }
        }
        int[] cnt = new int[4];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (answer[i][j] >= 1)
                    cnt[answer[i][j]]++;
            }
        }
        System.out.println(String.format("%d %d %d", cnt[1], cnt[2], cnt[3]));
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
