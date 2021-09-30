import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    private static final int INF = 101;
    private static void solution() throws Exception {
        int n = nextInt();
        int m = nextInt();

        // input
        int[][] arr = new int[n+1][n+1];
        for (int[] row : arr) Arrays.fill(row, INF);
        while (m-->0) arr[nextInt()][nextInt()] = 1;

        // floyd-washall
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i == j) continue;
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }

        // counting
        int[] rowCnt = new int[n+1];
        int[] colCnt = new int[n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j || arr[i][j] == INF) continue;
                rowCnt[i]++;
                colCnt[j]++;
            }
        }

        // answer
        int ref = n / 2 + 1;
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (rowCnt[i] >= ref) answer++;
            if (colCnt[i] >= ref) answer++;
        }
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

    private static byte read() throws IOException {
        if (curIdx == maxIdx) {
            maxIdx = inputStream.read(buffer, curIdx = 0, DEFAULT_BUFFER_SIZE);
            if (maxIdx == -1) buffer[0] = -1;
        }
        return buffer[curIdx++];
    }
}
