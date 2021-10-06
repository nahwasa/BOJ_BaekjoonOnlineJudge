import java.io.DataInputStream;
import java.io.IOException;

public class Main {
    private static final int MOD = 1000000009;
    private static void solution() throws Exception {
        int[][] dp = new int[100001][2];
        dp[0][0] = 1;
        for (int i = 1; i <= 100000; i++) {
            for (int j = 1; j <= 3; j++) {
                if (i-j < 0) continue;
                dp[i][1] += dp[i-j][0];
                dp[i][1] %= MOD;
                dp[i][0] += dp[i-j][1];
                dp[i][0] %= MOD;
            }
        }
        int t = nextInt();
        String s;
        StringBuilder sb = new StringBuilder();
        while (t-->0) {
            int cur = nextInt();
            sb.append(dp[cur][1]).append(' ').append(dp[cur][0]).append('\n');
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
