import java.io.DataInputStream;
import java.io.IOException;

public class Main extends FastInput {
    private int getM(int n, int[] x, int[] y, int tx, int ty) {
        int[] cnt = new int[4];
        for (int i = 0; i < n; i++) {
            int curX = x[i];
            int curY = y[i];
            if (curX > tx && curY > ty)         cnt[0]++;
            else if (curX > tx && curY < ty)    cnt[1]++;
            else if (curX < tx && curY > ty)    cnt[2]++;
            else                                cnt[3]++;
        }

        int max = 0;
        for (int i = 0; i < 4; i++) {
            if (max < cnt[i]) max = cnt[i];
        }
        return max;
    }

    private void solution() throws Exception {
        int n = nextInt();
        nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = nextInt();
            y[i] = nextInt();
        }

        int answer = n;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                answer = Math.min(answer, getM(n, x, y, x[i]+1, y[j]+1));
            }
        }
        System.out.println(answer);
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
