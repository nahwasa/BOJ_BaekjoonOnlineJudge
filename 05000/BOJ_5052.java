import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        initFI();
        int tc = nextInt();
        StringBuilder sb = new StringBuilder();
        while (tc-->0) {
            int n = nextInt();
            String[] arr = new String[n];
            while (n-->0)   arr[n] = nextLine();
            Arrays.sort(arr);
            boolean isOk = true;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i].indexOf(arr[i-1]) == 0) {
                    isOk = false;
                    break;
                }
            }
            if (isOk) sb.append('Y').append('E').append('S').append('\n');
            else sb.append('N').append('O').append('\n');
        }
        System.out.println(sb);
    }

    // Fast Input
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

    private static String nextLine() throws IOException {
        byte[] buf = new byte[64]; // line length
        int cnt = 0, c;
        while ((c = read()) != -1) {
            if (c == '\n') {
                if (cnt != 0) break;
                continue;
            }
            buf[cnt++] = (byte)c;
        }
        return new String(buf, 0, cnt);
    }

    private static byte read() throws IOException {
        if (curIdx == maxIdx) {
            maxIdx = inputStream.read(buffer, curIdx = 0, DEFAULT_BUFFER_SIZE);
            if (maxIdx == -1) buffer[0] = -1;
        }
        return buffer[curIdx++];
    }
}
