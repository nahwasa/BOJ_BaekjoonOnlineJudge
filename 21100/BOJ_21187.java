import java.io.DataInputStream;
import java.io.IOException;

public class Main extends FastInput {
    private void solution() throws Exception {
        int n = nextInt();
        int[] cnt = new int[20001];
        int sum = 0;
        while (n-->0) {
            int a = nextInt();
            sum += a;
            cnt[a]++;
        }
        int left = 0;
        int right = 0;
        for (int i = 1; i <= 20000; i++) {
            left += i * cnt[i];
            right = sum - left;
            if (cnt[i] == 0 && left == right) {
                System.out.println(i);
                return;
            }
            if ((cnt[i]&1)==1) {
                if (left-i*cnt[i] == right) {
                    System.out.println(i);
                    return;
                }
            } else {
                if (left-(i*cnt[i]/2) == right+(i*cnt[i]/2)) {
                    System.out.println(i);
                    return;
                }
            }
        }
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
