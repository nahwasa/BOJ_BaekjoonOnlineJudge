import java.io.DataInputStream;
import java.io.IOException;

public class Main {
    private void solution() throws Exception {
        int tc = nextInt();
        StringBuilder sb = new StringBuilder();
        while (tc-->0) {
            int d = nextInt();
            int n = nextInt();
            int s = nextInt();
            int p = nextInt();
            long c1 = 1l*d+n*p;
            long c2 = 1l*n*s;
            if (c1 == c2) {
                sb.append("does not matter");
            } else if (c1 > c2) {
                sb.append("do not parallelize");
            } else {
                sb.append("parallelize");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        initFI();
        new Main().solution();
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
        boolean neg = (c == '-');
        if (neg) c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        if (neg) return -ret;
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
