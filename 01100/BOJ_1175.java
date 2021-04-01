import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        boolean[][][][] v = new boolean[n][m][4][3];
        Pos start = null;
        int giftBit = 1;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                char c = s.charAt(j);
                switch (c) {
                    case 'S' : start = new Pos(i, j, -1, 0, 0); break;
                    case 'C' : arr[i][j] = giftBit++; break;
                    case '#' : arr[i][j] = -1; break;
                }
            }
        }
        start.gift = 0;

        //bfs
        Queue<Pos> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            Pos tmp = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || v[nx][ny][i][tmp.gift] || tmp.beforeDir == i || arr[nx][ny] == -1) continue;
                int giftTmp = tmp.gift;
                if (arr[nx][ny] >= 1 && (giftTmp & arr[nx][ny]) == 0)   giftTmp |= arr[nx][ny];
                if (giftTmp== 3) {
                    System.out.println(tmp.dist+1);
                    return;
                }
                v[nx][ny][i][giftTmp] = true;
                q.add(new Pos(nx, ny, i, giftTmp, tmp.dist+1));
            }
        }

        System.out.println(-1);
        br.close();
    }
}

class Pos {
    int x, y, beforeDir, gift, dist;
    public Pos(int x, int y, int beforeDir, int gift, int dist) {
        this.x = x;
        this.y = y;
        this.beforeDir = beforeDir;
        this.gift = gift;
        this.dist = dist;
    }
}
