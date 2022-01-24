import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;

public class Main extends FastInput {
    private int[] parents;

    private int find(int a) {
        if (parents[a] < 0) return a;
        return a = find(parents[a]);
    }

    private boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a==b) return true;

        int h = parents[a]<parents[b]?a:b;
        int l = parents[a]<parents[b]?b:a;
        parents[h] += parents[l];
        parents[l] = h;
        return false;
    }

    private void solution() throws Exception {
        int n = nextInt();
        int m = nextInt();
        parents = new int[n];
        Arrays.fill(parents, -1);
        for (int i = 1; i <= m; i++) {
            if (union(nextInt(), nextInt())) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
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
