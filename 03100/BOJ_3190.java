import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    private static final int BLOCK = -1;
    private static final int BLANK = 0;
    private static final int APPLE = 1;
    private static final int[] DR = new int[] {-1, 0, 1, 0};
    private static final int[] DC = new int[] {0, 1, 0, -1};
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private int[] pair(int r, int c) {
        return new int[] {r, c};
    }

    public void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n+2][n+2];
        for (int[] row : map) Arrays.fill(row, BLOCK);
        for (int i = 1; i <= n; i++) for (int j = 1; j <= n; j++) map[i][j] = BLANK;

        int k = Integer.parseInt(br.readLine());
        while (k-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = APPLE;
        }

        int[] dirChange = new int[10001];
        int l = Integer.parseInt(br.readLine());
        while (l-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            dirChange[Integer.parseInt(st.nextToken())] = st.nextToken().charAt(0)=='L'?-1:1;
        }

        int time = 0;
        Deque<int[]> dq = new ArrayDeque<>();
        dq.addLast(pair(1, 1));
        map[1][1] = BLOCK;
        int d = 1;
        while (true) {
            time++;
            int[] cur = dq.peekLast();
            int nr = cur[0]+DR[d];
            int nc = cur[1]+DC[d];
            if (map[nr][nc] == BLOCK) break;

            boolean isApple = map[nr][nc] == APPLE;
            dq.addLast(pair(nr, nc));
            map[nr][nc] = BLOCK;
            if (!isApple) {
                map[dq.peekFirst()[0]][dq.peekFirst()[1]] = BLANK;
                dq.pollFirst();
            }

            d += dirChange[time];
            if (d<0) d+=4;
            d%=4;
        }
        System.out.println(time);
    }
}
