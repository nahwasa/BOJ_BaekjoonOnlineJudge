import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main extends FastInput {
    private void solution() throws Exception {
        int n = nextInt();
        int[] inputData = new int[n];
        ArrayList<Integer> bs = new ArrayList<>();
        int[] idxOrder = new int[n];
        for (int i = 0; i < n; i++) {
            int cur = nextInt();
            inputData[i] = cur;
            if (bs.isEmpty() || bs.get(bs.size()-1) < cur) {
                idxOrder[i] = bs.size();
                bs.add(cur);
                continue;
            }
            int idx = Collections.binarySearch(bs, cur);
            idxOrder[i] = idx>=0?idx:-idx-1;
            bs.set(idxOrder[i], cur);
        }

        int[] result = new int[bs.size()];
        int resultIdx = 0;
        int idx = n;
        n = bs.size();
        while (n-->0) {
            while (--idx>=0) {
                if (idxOrder[idx] == n) {
                    result[resultIdx++] = inputData[idx];
                    break;
                }
            }
        }

        StringBuilder answer = new StringBuilder();
        answer.append(bs.size()).append('\n');
        for (int i = result.length-1; i >= 0; i--)
            answer.append(result[i]).append(' ');
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
