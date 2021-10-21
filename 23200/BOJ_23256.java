import java.io.DataInputStream;
import java.io.IOException;

public class Main2 {
    private static void solution() throws Exception {
        long[][] dp = new long[2][1000001];
        dp[0][1] = 7;
        dp[1][1] = 3;

        for (int i = 2; i <= 1000000; i++) {
            dp[0][i] = dp[0][i-1] * 3 + dp[1][i-1] * 4;
            dp[0][i] %= 1000000007;
            dp[1][i] = dp[0][i-1] + dp[1][i-1] * 2;
            dp[1][i] %= 1000000007;
        }

        int t = nextInt();
        StringBuilder sb = new StringBuilder();
        while (t-->0) {
            int n = nextInt();
            sb.append(dp[0][n]).append('\n');
        }
        System.out.println(sb);
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
