import java.io.DataInputStream;
import java.io.IOException;
import java.util.TreeSet;

public class Main extends FastInput {
    private final static int LIMIT = Integer.MAX_VALUE;

    private void solution() throws Exception {
        int k = nextInt();
        int n = nextInt();

        TreeSet<Integer> ts = new TreeSet<>();
        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = nextInt();
            ts.add(arr[i]);
        }

        n--;
        int max = arr[k-1];
        while (n-->0) {
            int cur = ts.pollFirst();
            for (int i = 0; i < k; i++) {
                long tmp = 1l*cur*arr[i];
                if (tmp > LIMIT) break;

                int next = (int)tmp;
                if (ts.size() > n && next > max) break;

                ts.add(next);
                if (max < next) max = next;
            }
        }
        System.out.println(ts.pollFirst());
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
