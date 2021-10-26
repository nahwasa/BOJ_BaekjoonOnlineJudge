import java.io.DataInputStream;
import java.io.IOException;
import java.util.HashSet;

public class Main {
    private static StringBuilder answer = new StringBuilder();
    private static void print(int tc, int ans) {
        answer.append('C').append('a').append('s').append('e').append(' ').append(tc).append(':').append(' ').append(ans).append('\n');
    }
    private static void flush() { System.out.println(answer); }

    private static void solution() throws Exception {
        int t = nextInt();
        for (int tc = 1; tc <= t; tc++) {
            HashSet<Integer> hs = new HashSet<>();
            int n = nextInt();
            int ans = 0;
            for (int i = 1; i <= n; i++) {
                if (hs.add(nextInt()))
                    ans = i;
            }
            print(tc, ans);
        }
        flush();
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
