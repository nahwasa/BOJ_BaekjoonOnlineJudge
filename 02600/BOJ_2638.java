import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    static int n, m;
    static int[][] map;
    static boolean[][] v;
    static final int[] DR = {-1, 1, 0, 0};
    static final int[] DC = {0, 0, 1, -1};

    private static void dfs(int r, int c) {
        for (int d = 0; d < 4; d++) {
            int nr = r + DR[d];
            int nc = c + DC[d];
            if (nr < 0 || nr >= n || nc < 0 || nc >= m || v[nr][nc]) continue;

            if (map[nr][nc] > 0) {
                map[nr][nc]++;
            } else {
                v[nr][nc] = true;
                dfs(nr, nc);
            }
        }
    }

    private static void solution() throws Exception {
        n = nextInt();
        m = nextInt();
        map = new int[n][m];
        v = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = nextInt();
            }
        }

        int answer = -1, cnt = -1;
        while (cnt != 0) {
            for (boolean[] row : v) Arrays.fill(row, false);
            v[0][0] = true;
            dfs(0, 0);

            cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] > 0) cnt++;
                    map[i][j] = map[i][j] >= 3 ? 0 : (map[i][j] >= 1 ? 1 : 0);
                }
            }
            answer++;
        }

        System.out.println(answer);
        return;
    }

    public static void main(String[] args) throws Exception {
        init();
        solution();
    }

    private static final int DEFAULT_BUFFER_SIZE = 1 << 16;
    private static DataInputStream inputStream;
    private static byte[] buffer;
    private static int curIdx, maxIdx;

    private static void init() {
        inputStream = new DataInputStream(System.in);
        buffer = new byte[DEFAULT_BUFFER_SIZE];
        curIdx = maxIdx = 0;
    }

    private static int nextInt() throws IOException {
        int ret = 0;
        byte c = read();
        while (c <= ' ') c = read();
        boolean neg = (c == '-');
        if (neg) c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        if (neg) return -ret;
        return ret;
    }


    private static byte read() throws IOException {
        if (curIdx == maxIdx) {
            maxIdx = inputStream.read(buffer, curIdx = 0, DEFAULT_BUFFER_SIZE);
            if (maxIdx == -1) buffer[0] = -1;
        }
        return buffer[curIdx++];
    }
}
