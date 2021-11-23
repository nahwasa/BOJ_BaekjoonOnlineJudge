import java.io.DataInputStream;
import java.io.IOException;

public class Main extends FastInput {
    private void solution() throws Exception {
        StringBuilder sb = new StringBuilder();
        while (true) {
            int n = nextInt();
            int m = nextIntExceptDot();
            if (n == 0 && m == 0) break;

            int[] dp = new int[m+1];
            for (int i = 0; i < n; i++) {
                int c = nextInt();
                int p = nextIntExceptDot();
                if (p > m) continue;

                for (int targetPrice = p; targetPrice <= m; targetPrice++) {
                    dp[targetPrice] = Math.max(dp[targetPrice], dp[targetPrice-p] + c);
                }
            }
            sb.append(dp[m]).append('\n');
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

    protected static int nextIntExceptDot() throws IOException {
        int ret = 0;
        byte c = read();
        while (c <= ' ') c = read();
        do {
            if (c == '.') continue;
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9' || c == '.');
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
