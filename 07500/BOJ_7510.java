import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        initFI();
        int tc = nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= tc; i++) {
            int[] arr = new int[3];
            for (int j = 0; j < 3; j++) arr[j] = nextInt();
            Arrays.sort(arr);
            sb.append('S').append('c').append('e').append('n').append('a').append('r').append('i').append('o');
            sb.append(' ').append('#').append(i).append(':').append('\n');
            if (arr[0]*arr[0] + arr[1]*arr[1] == arr[2]*arr[2]) sb.append('y').append('e').append('s').append('\n').append('\n');
            else sb.append('n').append('o').append('\n').append('\n');
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
