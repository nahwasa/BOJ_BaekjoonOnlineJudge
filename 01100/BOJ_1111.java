import java.io.DataInputStream;
import java.io.IOException;

public class Main {
    private static void solution() throws Exception {
        int n = nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextInt();
        }

        // 1
        if (n > 1 && arr[0] == arr[1]) {
            for (int i = 1; i < n; i++) {
                if (arr[i] != arr[0]) {
                    System.out.println('B');
                    return;
                }
            }
            System.out.println(arr[0]);
            return;
        }

        // 2
        if (n < 3) {
            System.out.println('A');
            return;
        }

        // 3
        if ((arr[2]-arr[1]) % (arr[1]-arr[0]) != 0) {
            System.out.println('B');
            return;
        }
        int a = (arr[2]-arr[1]) / (arr[1]-arr[0]);
        int b = arr[1] - a*arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i-1]*a+b != arr[i]) {
                System.out.println('B');
                return;
            }
        }
        System.out.println(arr[n-1]*a+b);
    }

    public static void main(String[] args) throws Exception{
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
