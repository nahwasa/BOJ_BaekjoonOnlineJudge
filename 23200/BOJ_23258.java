import java.io.DataInputStream;
import java.io.IOException;

public class Main extends FastInput {
    private static final int INF = 170324*300+1;

    private void init(int n, int[][][] arr) {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i == j || i == k || k == j)
                        arr[i][j][k] = arr[i][j][k-1];
                    else
                        arr[i][j][k] = Math.min(arr[i][j][k-1], arr[i][k][k-1] + arr[k][j][k-1]);
                }
            }
        }
    }

    private void solution() throws Exception {
        int n = nextInt();
        int q = nextInt();
        int[][][] arr = new int[n+1][n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j][0] = nextInt();
                if (arr[i][j][0] == 0)
                    arr[i][j][0] = INF;
            }
        }

        init(n, arr);

        StringBuilder sb = new StringBuilder();
        while (q-->0) {
            int c = nextInt();
            int s = nextInt();
            int e = nextInt();
            sb.append(s==e?0 : (arr[s][e][c-1] == INF ? -1 : arr[s][e][c-1])).append('\n');
        }
        System.out.print(sb);
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
