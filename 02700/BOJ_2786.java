import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    class Price {
        int a, b;
        public Price(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    private void orderByPriceB(Price[] arr) {
        Arrays.sort(arr, new Comparator<Price>() {
            @Override
            public int compare(Price o1, Price o2) {
                return o1.b - o2.b;
            }
        });
    }

    private void solution() throws IOException {
        int n = nextInt();
        Price[] arr = new Price[n+1];
        arr[0] = new Price(0, 0);
        for (int i = 1; i <= n; i++) {
            int a = nextInt();
            int b = nextInt();
            arr[i] = new Price(a, b);
        }

        // order by price b
        orderByPriceB(arr);

        // make prefix sum arr of price b & a-b arr
        long[] prefixSum = new long[n+1];
        int[] gapOfAandB = new int[n+1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i-1] + arr[i].b;
            gapOfAandB[i] = arr[i].a - arr[i].b;
        }

        // make arr of min A above i
        int[] minAaboveI = new int[n+1];
        int min = Integer.MAX_VALUE;
        for (int i = n; i > 0; i--) {
            if (arr[i].a < min)
                min = arr[i].a;
            minAaboveI[i] = min;
        }

        // solve
        int minGap = Integer.MAX_VALUE;
        StringBuilder answer = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (minGap > gapOfAandB[i])
                minGap = gapOfAandB[i];
            long sum = Math.min(prefixSum[i-1] + minAaboveI[i], prefixSum[i] + minGap);
            answer.append(sum).append('\n');
        }
        System.out.print(answer);
    }

    public static void main(String[] args) throws IOException {
        initFI();
        new Main().solution();
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
