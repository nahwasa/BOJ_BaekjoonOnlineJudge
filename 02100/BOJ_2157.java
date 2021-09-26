import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    private static final int INVALID = -1;
    private static void solution() throws Exception {
        int n = nextInt();
        int m = nextInt();
        int k = nextInt();

        int[][] edge = new int[n+1][n+1];
        for (int[] row : edge) Arrays.fill(row, INVALID);
        while (k-->0) {
            int a = nextInt();
            int b = nextInt();
            int c = nextInt();
            if (a >= b) continue;   // 서쪽에서 동쪽으로 이동하는 경우 제외
            edge[a][b] = Math.max(edge[a][b], c);   // 동일 노선에 더 작은 기내식 점수 제외
        }

        int[][] dp = new int[n+1][m+1]; // dp[i][j] - i:도시번호, j:이동횟수, value:i도시번호까지 j이동횟수로 얻은 최대 기내식 점수
        for (int[] row : dp) Arrays.fill(row, INVALID);
        dp[1][1] = 0;
        for (int curCity = 1; curCity < n; curCity++) {
            for (int arrivedCnt = 1; arrivedCnt < m; arrivedCnt++) {
                if (dp[curCity][arrivedCnt] == INVALID) continue;

                for (int nextCity = curCity+1; nextCity <= n; nextCity++) {
                    if (edge[curCity][nextCity] == INVALID) continue;
                    dp[nextCity][arrivedCnt+1] = Math.max(dp[nextCity][arrivedCnt+1], dp[curCity][arrivedCnt] + edge[curCity][nextCity]);
                }
            }
        }

        System.out.println(Arrays.stream(dp[n]).max().getAsInt());
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
