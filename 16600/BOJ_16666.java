import java.io.DataInputStream;
import java.io.IOException;

public class Main {
    private static void solution() throws Exception {
        int t = nextInt();
        StringBuilder sb = new StringBuilder();
        while (t-->0) {
            int min = Integer.MAX_VALUE;
            int k = nextInt();
            int[] arr = new int[7];
            int sum = 0;
            for (int i = 0; i < 7; i++) sum += arr[i] = nextInt();
            for (int i = 0; i < 7; i++) {
                if (arr[i] != 1) continue;
                int cur = 0;
                int tmp = k;
                for (int j = i; j < 7 && tmp != 0; j++) {
                    cur++;
                    tmp -= arr[j];
                }
                if (tmp == 0) {
                    min = Math.min(min, cur);
                    continue;
                }
                int week = tmp / sum;
                cur += 7 * week;
                tmp -= week * sum;
                if (tmp == 0) {
                    for (int j = 6; j >= 0; j--) {
                        if (arr[j] == 1) break;
                        cur--;
                    }
                }
                for (int j = 0; tmp != 0; j++) {
                    cur++;
                    tmp -= arr[j];
                }
                min = Math.min(min, cur);
            }
            sb.append(min).append('\n');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        initFI();
        solution();
    }

    private static final int DEFAULT_BUFFER_SIZE = 1 << 16;
    private static final int MAX_CHAR_LEN_FOR_NEXT_LINE = 20;
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
