import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Town implements Comparable<Town> {
    int a, p;
    @Override
    public int compareTo(Town o) {
        if (this.a == o.a)
            return o.p - this.p;
        return this.a-o.a;
    }
}
public class Main extends FastInput {
    int n, answer = 0;
    Town[] arr;

    private void dfs(int cur, int remain, int atk, int sum) {
        if (remain < 0) return;
        if (cur == n) {
            if (answer < sum) answer = sum;
            return;
        }
        dfs(cur+1, remain, atk, sum);
        dfs(cur+1, remain-arr[cur].a-atk, atk+arr[cur].a, sum+arr[cur].p);
    }

    private void solution() throws Exception {
        n = nextInt();
        int k = nextInt();
        arr = new Town[n];
        for (int i = 0; i < n; i++) arr[i] = new Town();
        for (int i = 0; i < n; i++) arr[i].a = nextInt();
        for (int i = 0; i < n; i++) arr[i].p = nextInt();
        Arrays.sort(arr);
        dfs(0, k, 0, 0);
        System.out.println(answer);
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
    private static final int MAX_CHAR_LEN_FOR_NEXT_LINE = 10000;
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
