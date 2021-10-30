import java.io.DataInputStream;
import java.io.IOException;

public class Main {
    private static int[][] arr;

    private int search(int cur, int h) {
        if (h == 0)
            return cur;
        return search(arr[h-1][cur] == 0 ? cur : arr[h-1][cur], h-1);
    }

    private void solution() throws Exception {
        StringBuilder sb = new StringBuilder();
        while (true) {
            int n = nextInt();
            int m = nextInt();
            int a = nextInt();
            if (n == 0) break;

            arr = new int[1001][n+1];
            while (m-->0) {
                int h = nextInt();
                int p = nextInt();
                int q = nextInt();
                arr[h][p] = q;
                arr[h][q] = p;
            }

            sb.append(search(a, 1001)).append('\n');
        }
        System.out.print(sb);
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
