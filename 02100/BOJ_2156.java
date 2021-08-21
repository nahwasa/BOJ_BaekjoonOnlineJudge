import java.io.DataInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        initFI();
        int n = nextInt();
        int[] arr = new int[3];
        while (n-->0) {
            int cur = nextInt();
            int[] tmp = new int[3];
            for (int i = 0; i < 3; i++)
                tmp[0] = Math.max(tmp[0], arr[i]);
            tmp[1] = arr[0] + cur;
            tmp[2] = arr[1] + cur;
            arr = tmp;
        }
        int answer = 0;
        for (int i = 0; i < 3; i++)
            answer = Math.max(answer, arr[i]);
        System.out.println(answer);
    }

    // Fast IO
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
