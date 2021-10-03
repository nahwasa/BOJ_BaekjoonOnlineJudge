import java.io.DataInputStream;
import java.io.IOException;

public class Main {
    private static final char BLOCK = '#';
    private static final char START = 'G';
    private static final char TARGET = 'S';
    private static char[][] map;
    private static int answer;

    private static void dfs(int r, int c, int cnt, int t) {
        if (t == -1) {
            answer = Math.max(answer, cnt);
            return;
        }
        if (cnt+t+1 < answer)
            return;

        boolean isTarget = false;
        if (map[r][c] == TARGET) {
            cnt++;
            map[r][c] = '.';
            isTarget = true;
        }

        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                if (((dr^dc)&1) != 1) continue;
                int nr = r + dr;
                int nc = c + dc;
                if (map[nr][nc] == BLOCK) continue;
                dfs(nr, nc, cnt, t-1);
            }
        }

        if (isTarget) {
            map[r][c] = TARGET;
        }
    }

    private static void solution() throws Exception {
        int r = nextInt();
        int c = nextInt();
        int t = nextInt();

        map = new char[r+2][c+2];
        answer = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = BLOCK;
            }
        }

        int startR = 0, startC = 0;
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                map[i][j] = nextChar();
                if (map[i][j] == START) {
                    startR = i;
                    startC = j;
                }
            }
        }

        dfs(startR, startC, 0, t);
        System.out.println(answer);

    }

    public static void main(String[] args) throws Exception {
        initFI();
        solution();
    }

    private static final int DEFAULT_BUFFER_SIZE = 1 << 16;
    private static DataInputStream inputStream;
    private static byte[] buffer;
    private static int curIdx, maxIdx;

    private static void initFI() {
        inputStream = new DataInputStream(System.in);
        buffer = new byte[DEFAULT_BUFFER_SIZE];
        curIdx = maxIdx = 0;
    }

    private static int nextInt() throws IOException {
        int ret = 0;
        byte c = read();
        while (c <= ' ') c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        return ret;
    }

    private static char nextChar() throws IOException {
        byte c = read();
        while (c <= ' ') c = read();
        return (char)c;
    }

    private static byte read() throws IOException {
        if (curIdx == maxIdx) {
            maxIdx = inputStream.read(buffer, curIdx = 0, DEFAULT_BUFFER_SIZE);
            if (maxIdx == -1) buffer[0] = -1;
        }
        return buffer[curIdx++];
    }
}
