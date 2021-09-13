import java.io.DataInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        initFI();
        StringBuilder sb = new StringBuilder();
        while (true) {
            int b = nextInt();
            int n = nextInt();
            if (b == 0 && n == 0) break;
            double root = Math.pow(b, (double)1 / n);
            long ceil = (long) Math.ceil(root);
            long floor = (long) Math.floor(root);
            double gap1 = Math.abs(Math.pow(ceil, n) - b);
            double gap2 = Math.abs(Math.pow(floor, n) - b);
            sb.append(gap1 <= gap2 ? ceil : floor).append('\n');
        }
        System.out.println(sb);
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
