import java.io.DataInputStream;
import java.io.IOException;

public class Main extends FastInput {
    private void solution() throws Exception {
        int n = nextInt();
        int m = nextInt();
        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = arr[i-1] + nextInt();
        }
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                if (arr[j]-arr[i-1] == m) cnt++;
            }
        }
        System.out.println(cnt);
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
