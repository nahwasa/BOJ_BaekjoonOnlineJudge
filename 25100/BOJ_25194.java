import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main extends FastInput {
    private static final int LIMIT = 100;
    int[] cnt;
    boolean chk = false;
    private void dfs(int sum) {
        if (sum > LIMIT) return;
        if (sum%7==4) {
            chk = true;
            return;
        }
        for (int i = 1; !chk && i <= 6; i++) {
            if (cnt[i] == 0) continue;
            cnt[i]--;
            dfs(sum+i);
            cnt[i]++;
        }
    }
    private void solution() throws Exception {
        cnt = new int[7];
        int n = nextInt();
        while (n-->0) {
            int cur = nextInt();
            if (cur%7==0) continue;
            cnt[cur%7]++;
        }
        if (cnt[4] != 0) {
            System.out.println("YES");
            return;
        }
        dfs(0);
        System.out.println(chk?"YES":"NO");
    }

    private static BufferedReader br;
    public static void main(String[] args) throws Exception {
        initFI();
//        initSI();
        new Main().solution();
    }
}

class FastInput {
    private static final int DEFAULT_BUFFER_SIZE = 1 << 16;
    private static final int MAX_CHAR_LEN_FOR_NEXT_LINE = 100010;
    private static DataInputStream inputStream;
    private static byte[] buffer;
    private static int curIdx, maxIdx;

    private static BufferedReader br;

    protected static void initFI() {
        inputStream = new DataInputStream(System.in);
        buffer = new byte[DEFAULT_BUFFER_SIZE];
        curIdx = maxIdx = 0;
    }

    protected static void initSI() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    protected static String nextLine() throws IOException {
        byte[] buf = new byte[MAX_CHAR_LEN_FOR_NEXT_LINE];
        int cnt = 0, c;
        while ((c = read()) != -1) {
            if (c == '\n') {
                if (cnt != 0) break;
                continue;
            }
            buf[cnt++] = (byte)c;
        }
        return new String(buf, 0, cnt);
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

    protected static long nextLong() throws IOException {
        long ret = 0;
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

    protected static double nextDouble() throws IOException {
        double ret = 0, div = 1;
        byte c = read();
        while (c <= ' ') c = read();
        boolean neg = (c == '-');
        if (neg) c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        if (c == '.') while ((c = read()) >= '0' && c <= '9') ret += (c - '0') / (div *= 10);
        if (neg) return -ret;
        return ret;
    }

    protected static char nextChar() throws IOException {
        byte c = read();
        while (c <= ' ') c = read();
        return (char)c;
    }

    protected static byte read() throws IOException {
        if (curIdx == maxIdx) {
            maxIdx = inputStream.read(buffer, curIdx = 0, DEFAULT_BUFFER_SIZE);
            if (maxIdx == -1) buffer[0] = -1;
        }
        return buffer[curIdx++];
    }
}
