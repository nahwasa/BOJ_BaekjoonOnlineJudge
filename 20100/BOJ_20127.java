import java.io.DataInputStream;
import java.io.IOException;

public class Main extends FastInput {
    private void solution() throws Exception {
        int n = nextInt();
        
        int inc = 0;
        int dec = 0;
        boolean isInc = true;
        boolean isDec = true;
        int[] arr = new int[n];
        arr[0] = nextInt();
        for (int i = 1; i < n; i++) {
            arr[i] = nextInt();
            if (isInc && arr[i] < arr[i-1]) {
                if (inc == 0) inc = i;
                else isInc = false;
            }
            if (isDec && arr[i] > arr[i-1]) {
                if (dec == 0) dec = i;
                else isDec = false;
            }
            if (!isDec && !isInc) {
                System.out.println(-1);
                return;
            }
        }

        if (isDec && isInc ) {
            if (inc == 0 && dec == 0) { // all same
                System.out.println(0);
            } else {
                System.out.println(Math.min(inc, dec)); //e.g. 5 4 5 5 5
            }
            return;
        }

        if (isInc && (inc == 0 || arr[0] >= arr[n-1])) {
            System.out.println(inc);
            return;
        }
        if (isDec && (dec == 0 || arr[0] <= arr[n-1])) {
            System.out.println(dec);
            return;
        }
        System.out.println(-1);
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
