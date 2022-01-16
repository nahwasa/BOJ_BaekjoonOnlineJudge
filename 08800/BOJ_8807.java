import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;

class Range implements Comparable<Range> {
    int a, b;
    public Range(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Range o) {
        if (this.a == o.a) return this.b - o.b;
        return this.a - o.a;
    }
}

public class Main extends FastInput {
    private void solution() throws Exception {
        int z = nextInt();
        StringBuilder sb = new StringBuilder();

        while (z-->0) {
            int n = nextInt();
            Range[] arr = new Range[n];
            while (n-->0) {
                arr[n] = new Range(nextInt(), nextInt());
            }
            Arrays.sort(arr);

            int s = arr[0].a;
            int e = arr[0].b;
            int cnt = 0;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i].a > e+1) {
                    cnt += e-s+1;
                    s = arr[i].a;
                }
                e = Math.max(e, arr[i].b);
            }
            cnt += e-s+1;

            sb.append(cnt).append('\n');
        }
        System.out.print(sb);
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
