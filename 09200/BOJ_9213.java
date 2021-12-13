import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;

public class Main extends FastInput {
    int[] arr;

    private void initBadness() {
        arr = new int[1000001];
        Arrays.fill(arr, 1);
        for (int i = 2; i <= 1000000/2; i++) {
            int base = i+i;
            while (base <= 1000000) {
                 arr[base] += i;
                 base += i;
            }
        }
    }

    private void solution() throws Exception {
        StringBuilder sb = new StringBuilder();
        initBadness();
        int tc = 0;
        while (true) {
            int start = nextInt();
            if (start == 0) break;
            int stop = nextInt();
            int badness = nextInt();

            int cnt = 0;
            for (int i = start; i <= stop; i++) {
                if (Math.abs(i-arr[i]) <= badness)
                    cnt++;
            }
            sb.append("Test ").append(++tc).append(':').append(' ').append(cnt).append('\n');
        }
        System.out.println(sb);
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
