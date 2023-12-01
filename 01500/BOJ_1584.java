import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
    private static final int[] DR = {1, 0, 0, -1};
    private static final int[] DC = {0, 1, -1, 0};
    private static final int WARNING = 1;
    private static final int DEATH = 2;
    private static final int INF = 250001;


    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        int[][] arr = new int[501][501];

        int n = Integer.parseInt(br.readLine());
        while (n-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            marking(arr, x1, y1, x2, y2, WARNING);
        }

        int m = Integer.parseInt(br.readLine());
        while (m-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            marking(arr, x1, y1, x2, y2, DEATH);
        }

        Deque<int[]> dq = new ArrayDeque<>();
        dq.addLast(new int[]{0,0,0});
        int[][] dist = new int[501][501];
        for (int[] row : dist) Arrays.fill(row, INF);
        dist[0][0] = 0;

        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            int x = cur[0];
            int y = cur[1];
            int curDist = cur[2];

            for (int d = 0; d < 4; d++) {
                int nr = x+DR[d];
                int nc = y+DC[d];

                if (nr>500||nr<0||nc>500||nc<0||arr[nr][nc]==DEATH) continue;
                if (dist[nr][nc] <= curDist + arr[nr][nc]) continue;

                dist[nr][nc] = curDist + arr[nr][nc];
                if (arr[nr][nc] == 0) dq.addFirst(new int[] {nr, nc, curDist});
                else dq.addLast(new int[] {nr, nc, curDist+1});
            }
        }

        System.out.println(dist[500][500] == INF ? -1 : dist[500][500]);
    }

    private void marking(int[][] arr, int x1, int y1, int x2, int y2, int mark) {
        int xs = x1<x2?x1:x2;
        int xe = x1<x2?x2:x1;
        int ys = y1<y2?y1:y2;
        int ye = y1<y2?y2:y1;

        for (int i = xs; i <= xe; i++) {
            for (int j = ys; j <= ye; j++) {
                arr[i][j] = mark;
            }
        }
    }
}
