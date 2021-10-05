import java.io.DataInputStream;
import java.io.IOException;

public class Main {
    private static int[] arr;
    private static int n, answer;

    private static void makeAllEven() {
        for (int i = 0; i < n; i++) {
            if ((arr[i]&1) == 1) {
                arr[i] -= 1;
                answer++;
            }
        }
    }

    private static void makeHalf() {
        if (isEnd())
            return;
        for (int i = 0; i < n; i++) {
            arr[i] /= 2;
        }
        answer++;
    }

    private static boolean isEnd() {
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0)
                return false;
        }
        return true;
    }

    private static void solution() throws Exception {
        answer = 0;
        n = nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = nextInt();
        while (!isEnd()) {
            makeAllEven();
            makeHalf();
        }
        System.out.println(answer);
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
