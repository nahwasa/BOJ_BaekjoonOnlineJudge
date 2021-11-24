import java.io.DataInputStream;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main extends FastInput {
    private void solution() throws Exception {
        int n = nextInt();
        int q = nextInt();

        int[][] sum = new int[n+1][3];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 3; j++)
                sum[i][j] = sum[i-1][j];
            sum[i][nextInt()-1]++;
        }

        StringBuilder sb = new StringBuilder();
        while (q-->0) {
            int a = nextInt();
            int b = nextInt();
            for (int j = 0; j < 3; j++)
                sb.append(sum[b][j]-sum[a-1][j]).append(' ');
            sb.append('\n');
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
