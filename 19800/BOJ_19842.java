import java.io.DataInputStream;
import java.io.IOException;

public class Main {
    private int answer = 0;

    private boolean proc(int n, int m) throws Exception {
        if (n-1 != m) {
            return false;
        }

        int[] arr = new int[n+1];
        arr[0] = 0;
        arr[n] = n+1;

        for (int i = 1; i <= m; i++) {
            arr[i] = nextInt();
        }

        boolean chk = false;
        for (int i = 1; i <= n; i++) {
            int gap = arr[i] - arr[i-1];
            if (gap < 0 || gap > 2 || (gap == 2 && chk))
                return false;
            if (gap == 2) {
                answer = i;
                chk = true;
            }
        }
        return true;
    }

    private void solution() throws Exception {
        int n = nextInt();
        int m = nextInt();
        System.out.println(proc(n, m) ? "Yes\n"+answer : "No");
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
