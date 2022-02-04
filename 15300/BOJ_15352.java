import java.io.DataInputStream;
import java.util.Arrays;

public class Main extends FastInput {
    private static final int OUT_BOUND = -1;
    private int[] parents, arr, left, right;

    private int find(int a) {
        if (parents[a] < 0) return a;
        return parents[a] = find(parents[a]);
    }

    private void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return;

        int h = parents[a]<parents[b]?a:b;
        int l = parents[a]<parents[b]?b:a;
        parents[h] += parents[l];
        parents[l] = h;
    }

    private void init(int n) {
        parents = new int[n+1];
        Arrays.fill(parents, -1);

        arr = new int[n+1];
        left = new int[n+1];
        right = new int[n+1];
    }

    private void solution() throws Exception {
        nextInt();  //throw
        int n = nextInt();
        init(n);

        for (int i = 1; i <= n; i++) {
            arr[i] = nextInt();
            if (arr[i] == arr[i-1])
                union(i-1, i);

            left[i] = i-1;
            right[i] = i+1;
        }
        left[1] = right[n] = OUT_BOUND;

        long sum = 0;
        int q = nextInt();
        while (q-->0) {
            int a = nextInt();
            int b = nextInt();
            if (a == 2) {
                sum-=parents[find(b)];
            } else {
                parents[find(b)]++;
                int lower = left[b];
                int higher = right[b];
                if (lower != OUT_BOUND && higher != OUT_BOUND && arr[lower] == arr[higher])
                    union(lower, higher);

                if (lower != OUT_BOUND)
                    right[lower] = higher;
                if (higher != OUT_BOUND)
                    left[higher] = lower;
            }
        }
        System.out.println(sum);
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

    protected static int nextInt() throws Exception {
        int ret = 0;
        byte c = read();
        while (c <= ' ') c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        return ret;
    }

    private static byte read() throws Exception {
        if (curIdx == maxIdx) {
            maxIdx = inputStream.read(buffer, curIdx = 0, DEFAULT_BUFFER_SIZE);
            if (maxIdx == -1) buffer[0] = -1;
        }
        return buffer[curIdx++];
    }
}
