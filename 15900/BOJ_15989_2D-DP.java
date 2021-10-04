import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    private static void solution() throws Exception {
        int t = nextInt();
        StringBuilder sb = new StringBuilder();
        int chkMax = 1;
        int[][] dp = new int[Math.max(4, 10000+1)][4];
        dp[1][1] = dp[2][2] = dp[3][3] = 1;
        while (t-->0) {
            int n = nextInt();
            for (int i = chkMax+1; i <= n; i++) {
                for (int j = 1; j <= 3; j++) {
                    if (i-j <= 0) continue;
                    for (int k = 1; k <= j; k++) {
                        dp[i][j] += dp[i-j][k];
                    }
                }
            }
            chkMax = Math.max(chkMax, n);
            sb.append(Arrays.stream(dp[n]).sum()).append('\n');
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
