import java.io.DataInputStream;
import java.io.IOException;

public class Main {
    private static int[] mem;

    private static int calc(int n) {
        if (n <= 3) return n;
        return 1 + n/2 + mem[n-3];
    }

    private static void solution() throws Exception {
        int t = nextInt();
        mem = new int[10000+1];
        for (int i = 1; i <= 10000; i++)
            mem[i] = calc(i);

        StringBuilder sb = new StringBuilder();
        while (t-->0)
            sb.append(mem[nextInt()]).append('\n');
        System.out.println(sb);
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
