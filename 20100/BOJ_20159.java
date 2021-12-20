import java.io.DataInputStream;
import java.io.IOException;

public class Main extends FastInput {
    int n;
    int[] oddPrefixSum, evenPrefixSum;

    private int getOddPrefixSumUntil(int until) {
        return oddPrefixSum[until];
    }

    private int getEvenPrefixSumFrom(int from) {
        return evenPrefixSum[n/2] - evenPrefixSum[from];
    }

    private void solution() throws Exception {
        n = nextInt();
        oddPrefixSum = new int[n/2+1];
        evenPrefixSum = new int[n/2+1];
        for (int i = 1; i <= n/2; i++) {
            oddPrefixSum[i] = oddPrefixSum[i-1] + nextInt();
            evenPrefixSum[i] = evenPrefixSum[i-1] + nextInt();
        }

        int answer = 0;
        int lastEvenCard = getEvenPrefixSumFrom(n/2-1);
        for (int i = 0; i <= n/2; i++) {
            int odd = getOddPrefixSumUntil(i);
            int even = getEvenPrefixSumFrom(i);
            if (i != 0) {
                even = Math.max(even, getEvenPrefixSumFrom(i-1)-lastEvenCard);
            }

            int sum = odd+even;
            if (answer < sum)
                answer = sum;
        }
        System.out.println(answer);
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
