import java.io.DataInputStream;
import java.io.IOException;

public class Main {
    private static void solution() throws Exception {
        int s1r = nextInt();
        int s1c = nextInt();
        int s2r = nextInt();
        int s2c = nextInt();
        int e1r = nextInt();
        int e1c = nextInt();
        int e2r = nextInt();
        int e2c = nextInt();
        double sGap = Math.sqrt(Math.pow(s1r-s2r, 2) + Math.pow(s1c-s2c, 2));
        double eGap = Math.sqrt(Math.pow(e1r-e2r, 2) + Math.pow(e1c-e2c, 2));
        System.out.println(String.format("%.7f", Math.max(sGap, eGap)));
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
