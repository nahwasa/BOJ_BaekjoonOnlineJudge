import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    private static void solution() throws Exception {
        int n = nextInt();
        int k = nextInt();
        int q = nextInt();
        int m = nextInt();

        int[] arr = new int[n+3];
        Arrays.fill(arr, 1);

        boolean[] isSleep = new boolean[n+3];

        while (k-->0) {
            isSleep[nextInt()] = true;
        }

        while (q-->0) {
            int cur = nextInt();
            if (isSleep[cur]) continue;
            int next = 0;
            while ((next+=cur) <= n+2) {
                if (isSleep[next]) continue;
                arr[next] = 0;
            }
        }

        for (int i = 3; i <= n+2; i++) {
            arr[i] += arr[i-1];
        }

        StringBuilder sb = new StringBuilder();
        while (m-->0) {
            int s = nextInt();
            int e = nextInt();
            sb.append(arr[e] - arr[s-1]).append('\n');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        initFI();
        solution();
    }

    private static final int DEFAULT_BUFFER_SIZE = 1 << 16;
    private static final int MAX_CHAR_LEN_FOR_NEXT_LINE = 64;
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
