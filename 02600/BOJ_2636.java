import java.io.DataInputStream;
import java.io.IOException;

public class Main extends FastInput {
    boolean removed;
    boolean[][] v;

    private boolean hourProc(int r, int c, int[][] arr, int hour, int cr, int cc) {
        if (arr[cr][cc] == 1) {
            arr[cr][cc] = -hour;
            removed = true;
            return removed;
        }

        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                if (((dr^dc)&1)==0) continue;

                int nr = cr+dr;
                int nc = cc+dc;
                if (nr < 0 || nr >= r || nc < 0 || nc >= c || v[nr][nc]) continue;
                v[nr][nc] = true;
                hourProc(r, c, arr, hour, nr, nc);
            }
        }
        return removed;
    }

    private void removePiece(int r, int c, int[][] arr, int cr, int cc) {
        if (arr[cr][cc] == 1) {
            arr[cr][cc] = 0;
            return;
        }

        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                if (((dr^dc)&1)==0) continue;

                int nr = cr+dr;
                int nc = cc+dc;
                if (nr < 0 || nr >= r || nc < 0 || nc >= c || v[nr][nc]) continue;
                removePiece(r, c, arr, nr, nc);
            }
        }
    }

    private void solution() throws Exception {
        int r = nextInt();
        int c = nextInt();
        int[][] arr = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[i][j] = nextInt();
            }
        }

        int hour = 0;
        do {
            v = new boolean[r][c];
            removed = false;
        } while (hourProc(r, c, arr, ++hour, 0, 0));

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] == -(hour-1))
                    arr[i][j] = 1;
                else
                    arr[i][j] = 0;
            }
        }

        int lastSplitCnt = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j]==1) {
                    lastSplitCnt++;
                    v = new boolean[r][c];
                    removePiece(r, c, arr, i, j);
                }
            }
        }
        System.out.println(hour-1);
        System.out.println(lastSplitCnt);
    }

    public static void main(String[] args) throws Exception {
        initFI();
        new Main().solution();
    }
}

class FastInput {
    private static final int DEFAULT_BUFFER_SIZE = 1 << 16;
    private static DataInputStream inputStream;
    private static byte[] buffer;
    private static int curIdx, maxIdx;

    protected static void initFI() {
        inputStream = new DataInputStream(System.in);
        buffer = new byte[DEFAULT_BUFFER_SIZE];
        curIdx = maxIdx = 0;
    }

    protected static int nextInt() throws IOException {
        int ret = 0;
        byte c = read();
        while (c <= ' ') c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
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
